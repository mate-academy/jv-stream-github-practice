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
    private static final Predicate<Candidate> CANDIDATE_VALIDATOR = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers
                .stream()
                .flatMap(l -> Arrays.stream(l.split(",")))
                .mapToInt(Integer::valueOf)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Can't get average value from list: "
                        + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList
                .stream()
                .filter(p -> p.getSex().equals(Person.Sex.MAN)
                        && p.getAge() >= fromAge && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList
                .stream()
                .filter(p -> p.getAge() >= fromAge
                        && ((p.getSex().equals(Person.Sex.MAN) && p.getAge() <= maleToAge)
                        || (p.getSex().equals(Person.Sex.WOMAN) && p.getAge() <= femaleToAge)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList
                .stream()
                .filter(p -> p.getSex().equals(Person.Sex.WOMAN)
                        && p.getAge() >= femaleAge && p.getCats().size() > 0)
                .flatMap(l -> l.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates
                .stream()
                .filter(CANDIDATE_VALIDATOR)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
