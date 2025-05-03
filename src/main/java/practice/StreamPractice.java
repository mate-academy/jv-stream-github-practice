package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final int NUMBER_TO_SUBTRACT = 1;
    private static final String COMA = ",";
    private static final Enum<Person.Sex> MAN = Person.Sex.MAN;
    private static final Enum<Person.Sex> WOMAN = Person.Sex.WOMAN;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(e -> Arrays.stream(e.split(COMA)))
                .map(Integer::parseInt)
                .mapToInt(e -> e)
                .filter(e -> e % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> (i % 2 != 0)
                        ? numbers.get(i) - NUMBER_TO_SUBTRACT
                        : numbers.get(i))
                .filter(i -> i % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(i -> i.getAge() >= fromAge
                        && i.getAge() <= toAge
                        && i.getSex() == MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> sortPeople = person -> person.getSex() == Person.Sex.MAN
                ? person.getAge() >= fromAge && person.getAge() <= maleToAge
                : person.getAge() >= fromAge && person.getAge() <= femaleToAge;

        return peopleList.stream()
                .filter(sortPeople)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(i -> i.getSex() == WOMAN
                        && i.getAge() >= femaleAge)
                .flatMap(i -> i.getCats().stream())
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
}
