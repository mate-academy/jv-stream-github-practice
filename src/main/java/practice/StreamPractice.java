package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String NUMBERS_DIVIDER = ",";

    public int findMinEvenNumber(List<String> numbers) {
        Supplier<RuntimeException> exceptionSupplier = () ->
                new RuntimeException("Can't get min value from list: " + numbers);
        return numbers.stream()
                .map(s -> s.split(NUMBERS_DIVIDER))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min(Comparator.naturalOrder())
                .orElseThrow(exceptionSupplier);
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return Stream.iterate(0, i -> i + 1).limit(numbers.size())
                .peek(System.out::println)
                .map(i -> (i % 2 != 0) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 == 1)
                .mapToInt(n -> n)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> predicate = person ->
                person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicate = person ->
                (person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge)
                || (person.getSex() == Person.Sex.WOMAN && person.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN && p.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
