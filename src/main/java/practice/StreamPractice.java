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
    private static final int EVEN_OR_ODD_NUMBER_DIVIDER = 2;
    private static final int DECREMENT_ONE = 1;
    private static final String DELIMETER = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(DELIMETER)))
                .mapToInt(Integer::parseInt)
                .filter(i -> i % EVEN_OR_ODD_NUMBER_DIVIDER == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list:"
                        + numbers));
    }

    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(index -> {
                    if (index % EVEN_OR_ODD_NUMBER_DIVIDER != 0) {
                        return numbers.get(index) - DECREMENT_ONE;
                    }
                    return numbers.get(index);
                })
                .filter(number -> number % EVEN_OR_ODD_NUMBER_DIVIDER != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge && person.getAge() <= toAge
                        && person.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {

        return peopleList.stream()
                .filter(person -> (person.getAge() >= fromAge && person.getAge() <= maleToAge
                        && person.getSex() == Person.Sex.MAN)
                        || (person.getAge() >= fromAge && person.getAge() <= femaleToAge
                                && person.getSex() == Person.Sex.WOMAN))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= femaleAge
                        && person.getSex() == Person.Sex.WOMAN
                        && !person.getCats().isEmpty())
                .flatMap(person -> person.getCats().stream())
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
