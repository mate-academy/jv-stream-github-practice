package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {
    private static final String ERROR_MIN_MESSAGE = "Can't get min value from list: ";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(value -> value % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(ERROR_MIN_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                .filter(value -> value % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List hasn't odd numbers"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(e -> e.getAge() >= fromAge
                        && e.getAge() <= toAge
                        && e.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(e -> e.getAge() >= fromAge
                        && ((e.getSex() == Person.Sex.MAN && e.getAge() <= maleToAge)
                        || (e.getSex() == Person.Sex.WOMAN && e.getAge() <= femaleToAge)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(e -> e.getAge() > femaleAge && e.getSex() == Person.Sex.WOMAN)
                .flatMap(l -> l.getCats().stream())
                .map(l -> l.getName())
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
