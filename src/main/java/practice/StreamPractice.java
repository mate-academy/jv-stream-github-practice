package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public static final int TWO_FOR_ODD_CHECK = 2;
    public static final int ZERO_FOR_ODD_CHECK = 0;
    public static final String NO_ODD_ELEMENTS = "No odd elements";
    public static final String CANT_GET_MIN_VALUE = "Can't get min value from list: ";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(i -> i % TWO_FOR_ODD_CHECK == ZERO_FOR_ODD_CHECK)
                .min()
                .orElseThrow(() -> new RuntimeException(CANT_GET_MIN_VALUE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(ZERO_FOR_ODD_CHECK, numbers.size())
                .map(i -> i % TWO_FOR_ODD_CHECK == ZERO_FOR_ODD_CHECK
                        ? numbers.get(i) : numbers.get(i) - 1)
                .filter(number -> number % TWO_FOR_ODD_CHECK != ZERO_FOR_ODD_CHECK)
                .average()
                .orElseThrow(() -> new NoSuchElementException(NO_ODD_ELEMENTS));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() > fromAge
                        && person.getAge() <= toAge
                        && person.getSex().equals(Person.Sex.MAN))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge
                        && ((person.getSex().equals(Person.Sex.MAN)
                        && (person.getAge() <= maleToAge)
                        || (person.getSex().equals(Person.Sex.WOMAN)
                        && (person.getAge() <= femaleToAge)))))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= femaleAge
                        && person.getSex().equals(Person.Sex.WOMAN)
                        && (!person.getCats().isEmpty()))
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidate -> new CandidateValidator().test(candidate))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
