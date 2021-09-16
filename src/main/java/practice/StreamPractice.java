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
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(",")))
                .mapToInt(Integer::valueOf)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException("There is no odd numbers"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> filteredPerson = p -> (p.getSex() == Person.Sex.MAN
                && p.getAge() >= fromAge
                && p.getAge() <= toAge);
        return peopleList.stream()
                .filter(filteredPerson)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> filteredPerson = p -> (p.getSex() == Person.Sex.WOMAN
                && p.getAge() >= fromAge && p.getAge() <= femaleToAge)
                || (p.getSex().equals(Person.Sex.MAN)
                && p.getAge() >= fromAge && p.getAge() <= maleToAge);
        return peopleList.stream()
                .filter(filteredPerson)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> filteredPerson = p -> p.getSex() == Person.Sex.WOMAN
                && p.getAge() >= femaleAge
                && p.getCats().size() > 0;
        return peopleList.stream()
                .filter(filteredPerson)
                .flatMap(p -> p.getCats().stream())
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
