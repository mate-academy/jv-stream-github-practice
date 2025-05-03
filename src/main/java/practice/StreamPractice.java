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
    public static final String COMA = ",";
    public static final int DIVISION = 2;
    public static final int SUBTRACT = 1;
    private final Predicate<Integer> isEvenNumber = n -> n % DIVISION == 0;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(num -> Arrays.stream(num.split(COMA)))
                .mapToInt(Integer::valueOf)
                .filter(isEvenNumber::test)
                .min()
                .orElseThrow(()
                        -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> !isEvenNumber.test(i) ? numbers.get(i) - SUBTRACT : numbers.get(i))
                .filter(number -> !isEvenNumber.test(number))
                .average()
                .orElseThrow(()
                        -> new NoSuchElementException("Elements on odd index not found"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() > fromAge
                        && person.getAge() <= toAge
                        && person.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge
                        && ((person.getAge() <= maleToAge
                        && person.getSex() == Person.Sex.MAN)
                        || (person.getAge() <= femaleToAge
                        && person.getSex() == Person.Sex.WOMAN)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex().equals(Person.Sex.WOMAN)
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
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
