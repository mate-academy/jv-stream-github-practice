package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String NUMBERS_SPLITTER = ",";
    private static final int SUBTRACT_NUMBER = 1;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(NUMBERS_SPLITTER))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::valueOf)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new NoSuchElementException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(x -> x % 2 != 0
                        ? numbers.get(x) - SUBTRACT_NUMBER
                        : numbers.get(x))
                .filter(x -> x % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(canPersonBeRecruit(fromAge, toAge, Person.Sex.MAN))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(canPersonWork(fromAge, maleToAge, femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= femaleAge
                && p.getSex() == Person.Sex.WOMAN)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private Predicate<Person> canPersonBeRecruit(int minAge, int maxAge, Person.Sex sex) {
        return person -> person.getAge() >= minAge
                && person.getAge() <= maxAge
                && person.getSex() == sex;
    }

    private Predicate<Person> canPersonWork(int fromAge, int maleToAge, int femaleToAge) {
        return person -> person.getSex() == Person.Sex.MAN
                && (person.getAge() >= fromAge && person.getAge() <= maleToAge)
                || person.getSex() == Person.Sex.WOMAN
                && (person.getAge() >= fromAge && person.getAge() <= femaleToAge);
    }
}
