package practice;

import java.util.*;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> Arrays.asList(s.split(",")))
                .flatMap(Collection::stream)
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> numbers.indexOf(n) % 2 != 0)
                .forEach(n -> numbers.set(numbers.indexOf(n), --n));
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToDouble(Double::valueOf)
                .average().orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge
                        && (p.getSex() == Person.Sex.MAN && p.getAge() <= maleToAge
                        || p.getSex() == Person.Sex.WOMAN && p.getAge() <= femaleToAge))
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
        return candidates.stream()
                .filter(e -> new CandidateValidator().test(e))
                .map(Candidate::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }
}
