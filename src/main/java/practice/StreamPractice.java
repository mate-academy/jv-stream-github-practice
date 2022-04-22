package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final int ZERO_NUMBER = 0;
    private static final int SUBTRACT_NUMBER = 1;
    private static final int CHECKING_NUMBER = 2;

    public int findMinEvenNumber(List<String> numbers) {
        return Integer.parseInt(numbers.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .filter(n -> Integer.parseInt(n) % CHECKING_NUMBER == 0)
                .min(Comparator.comparingInt(Integer::parseInt))
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list:" + numbers)));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(ZERO_NUMBER, numbers.size())
                .map(i -> i % CHECKING_NUMBER != ZERO_NUMBER
                        ? numbers.get(i) - SUBTRACT_NUMBER : numbers.get(i))
                .filter(n -> n % CHECKING_NUMBER != ZERO_NUMBER)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(f -> f.getSex().equals(Person.Sex.MAN)
                        && f.getAge() >= fromAge
                        && f.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.MAN)
                        && p.getAge() >= fromAge
                        && p.getAge() <= maleToAge
                        || p.getSex().equals(Person.Sex.WOMAN)
                        && p.getAge() >= fromAge
                        && p.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.WOMAN)
                        && p.getAge() >= femaleAge)
                .flatMap(i -> i.getCats().stream())
                .map(Cat::getName).collect(Collectors.toList());
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
