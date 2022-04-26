package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public static final String CONSTANT_COMA = ",";
    public static final int CONSTANT_DIVISION = 2;
    public static final int CONSTANT_SUBTRACT = 1;
    private final Predicate<Integer> evenNumber = n -> n % CONSTANT_DIVISION == 0;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(CONSTANT_COMA)))
                .mapToInt(Integer::parseInt)
                .filter(evenNumber::test)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> !evenNumber.test(i)
                        ? numbers.get(i) - CONSTANT_SUBTRACT : numbers.get(i))
                .filter(number -> !evenNumber.test(number))
                .average()
                .orElseThrow(() -> new NoSuchElementException("No odd numbers in list: "
                        + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && fromAge <= p.getAge()
                        && toAge >= p.getAge())
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge
                        && ((person.getSex() == Person.Sex.WOMAN
                        && person.getAge() <= femaleToAge)
                        || (person.getSex() == Person.Sex.MAN
                        && person.getAge() <= maleToAge)))
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
