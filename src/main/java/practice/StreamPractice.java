package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String COMMA = ",";
    private final CandidateValidator validator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(COMMA))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> isOdd(i) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(this::isOdd)
                .average()
                .orElseThrow(() -> new NoSuchElementException(
                        "No such element in list " + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> filterMan(p, fromAge, toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> isWorkable(p, fromAge, femaleToAge, maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> filterCatOwner(p, femaleAge))
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean filterCatOwner(Person person, int femaleAge) {
        return person.getSex().equals(Person.Sex.WOMAN) && person.getAge() >= femaleAge;
    }

    private boolean filterMan(Person person, int fromAge, int toAge) {
        return person.getSex().equals(Person.Sex.MAN)
                && checkAge(person, fromAge, toAge);
    }

    private boolean isWorkable(Person person, int fromAge,
                               int femaleToAge, int maleToAge) {
        return person.getSex().equals(Person.Sex.WOMAN) ? womanFilter(person, fromAge, femaleToAge)
                : filterMan(person, fromAge, maleToAge);

    }

    private boolean womanFilter(Person person, int fromAge, int toAge) {
        return person.getSex().equals(Person.Sex.WOMAN)
                && checkAge(person, fromAge, toAge);
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

    private boolean checkAge(Person person, int fromAge, int toAge) {
        return person.getAge() >= fromAge && person.getAge() <= toAge;
    }
}
