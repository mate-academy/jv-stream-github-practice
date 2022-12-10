package practice;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final int AMOUNT_TO_BE_SUBTRACTED = 1;

    public int findMinEvenNumber(List<String> numbers) {
        OptionalInt min = numbers.stream()
                .map(s -> Arrays.asList(s.split(",")))
                .flatMap(List::stream)
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .filter(i -> i % 2 == 0)
                .min();
        return min.orElseThrow(()
                -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0,numbers.size())
                .map(index -> index % 2 != 0
                        ? numbers.get(index) - AMOUNT_TO_BE_SUBTRACTED : numbers.get(index))
                .filter(number -> number % 2 != 0)
                .average().getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> customPredicate = person -> person.getAge() >= fromAge
                && ((person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge)
                || (person.getSex() == Person.Sex.WOMAN && person.getAge() <= femaleToAge));
        return peopleList.stream()
                .filter(customPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> customPredicate = person -> person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge
                && !person.getCats().isEmpty();
        return peopleList.stream()
                .filter(customPredicate)
                .map(Person::getCats)
                .flatMap(List::stream)
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
