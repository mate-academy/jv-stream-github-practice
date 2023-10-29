package practice;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String BAD_INPUT_MESSAGE = "No odd numbers in the list";
    private static final String MIN_VALUE_ERROR_MESSAGE = "Can't get min value from list: %s";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(str -> Stream.of(str.split(",")))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException(
                        String.format(MIN_VALUE_ERROR_MESSAGE, numbers)));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(number -> number % 2 != 0 ? numbers.get(number) - 1
                        : numbers.get(number))
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException(BAD_INPUT_MESSAGE));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person ->
                        (person.getSex() == Person.Sex.MAN && person.getAge() >= fromAge
                                && person.getAge() <= maleToAge)
                                || (person.getSex() == Person.Sex.WOMAN
                                && person.getAge() >= fromAge
                                && person.getAge() <= femaleToAge)
                )
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= femaleAge
                        && person.getSex().equals(Person.Sex.WOMAN))
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
                .toList();
    }
}
