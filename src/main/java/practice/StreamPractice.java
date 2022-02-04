package practice;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        Supplier<RuntimeException> newRunTimeException = ()
                -> new RuntimeException("Can't get min value from list " + numbers);
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(newRunTimeException);
    }

    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        Supplier<NoSuchElementException> newNoSuchElementException = ()
                -> new NoSuchElementException("There is not odd elements in list: " + numbers);
        return numbers.stream()
                .filter(i -> numbers.indexOf(i) % 2 != 0)
                .map(n -> n - 1)
                .filter(n -> n % 2 != 0)
                .mapToDouble(Double::valueOf)
                .average()
                .orElseThrow(newNoSuchElementException);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> findManByAge = p -> p.getAge() >= fromAge
                && p.getAge() <= toAge
                && p.getSex().equals(Person.Sex.MAN);
        return peopleList.stream()
                .filter(findManByAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> findWomenAndMenByAge = p -> p.getAge() >= fromAge
                && (p.getSex().equals(Person.Sex.MAN) && p.getAge() <= maleToAge
                || p.getSex().equals(Person.Sex.WOMAN) && p.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(findWomenAndMenByAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> findWomenByAge = p -> p.getSex().equals(Person.Sex.WOMAN)
                && p.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(findWomenByAge)
                .flatMap(l -> l.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    /**
     * Your help with a election is needed. Given list of candidates, where each element
     * has Candidate.class type.
     * Check which candidates are eligible to apply for president position and return their
     * names sorted alphabetically.
     * The requirements are: person should be older than 35 years, should be allowed to vote,
     * have nationality - 'Ukrainian'
     * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
     * which has following view: "2002-2015"
     * We want to reuse our validation in future, so let's write our own impl of Predicate
     * parametrized with Candidate in CandidateValidator.
     */
    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(c -> new CandidateValidator().test(c))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
