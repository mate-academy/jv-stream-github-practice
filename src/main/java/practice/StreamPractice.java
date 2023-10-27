package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private final Predicate<Candidate> predicate = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
            .map(e -> e.split(","))
            .flatMap(Arrays::stream)
            .map(Integer::parseInt)
            .filter(e -> e % 2 == 0)
            .sorted()
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    /**
     * Given a List of Integer numbers, return the average of all odd numbers from the list or throw
     * NoSuchElementException. But before that subtract 1 from each element on an odd position
     * (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
            .map(index -> {
                if (index % 2 != 0) {
                    return numbers.get(index) - 1;
                }
                return numbers.get(index);
            })
            .filter(number -> number % 2 != 0)
            .average().orElseThrow(() -> new NoSuchElementException("Empty List provided"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
            .filter(person -> person.getSex().name().equals("MAN"))
            .filter(person -> person.getAge() >= fromAge)
            .filter(person -> person.getAge() <= toAge)
            .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
            int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
            .filter(person -> {
                if (person.getSex().name().equals("MAN")) {
                    return person.getAge() >= fromAge && person.getAge() <= maleToAge;
                }
                return person.getAge() >= fromAge && person.getAge() <= femaleToAge;
            })
            .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
            .filter(person -> person.getSex().name().equals("WOMAN"))
            .filter(person -> person.getAge() >= femaleAge)
            .flatMap(person -> person.getCats().stream())
            .map(Cat::getName)
            .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
            .filter(predicate)
            .map(Candidate::getName)
            .sorted()
            .toList();
    }
}
