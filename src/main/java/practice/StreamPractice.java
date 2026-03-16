package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {
    private static final String MIN_VALUE_EXCEPTION_MESSAGE_PREFIX =
            "Can't get min value from list: ";

    /**
     * Given list of strings where each element contains 1+ numbers:
     * input = {"5,30,100", "0,22,7", ...}
     * return min integer value. One more thing - we're interested in even numbers.
     * If there is no needed data throw RuntimeException with message
     * "Can't get min value from list: < Here is our input 'numbers' >"
     */
    public int findMinEvenNumber(List<String> numbers) {
        if (numbers == null) {
            throw new RuntimeException(MIN_VALUE_EXCEPTION_MESSAGE_PREFIX + numbers);
        }
        return numbers.stream()
                .filter(Objects::nonNull)
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(MIN_VALUE_EXCEPTION_MESSAGE_PREFIX
                        + numbers));
    }

    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        if (numbers == null) {
            throw new NoSuchElementException();
        }
        return IntStream.range(0, numbers.size())
                .map(i -> {
                    Integer v = numbers.get(i);
                    int value = v == null ? 0 : v;
                    if (i % 2 == 1) {
                        value = value - 1;
                    }
                    return value;
                })
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     * Given a List of `Person` instances (having `name`, `age` and `sex` fields),
     * select from the List only men whose age is from `fromAge` to `toAge` inclusively.
     */
    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        if (peopleList == null) {
            return Collections.emptyList();
        }
        return peopleList.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getSex() == Person.Sex.MAN)
                .filter(p -> p.getAge() >= fromAge && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    /**
     * Given a List of `Person` instances, select from the
     * List only people whose age is from `fromAge`
     * and to `maleToAge` (for men) or to `femaleToAge` (for women) inclusively.
     */
    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        if (peopleList == null) {
            return Collections.emptyList();
        }
        return peopleList.stream()
                .filter(Objects::nonNull)
                .filter(p -> {
                    int age = p.getAge();
                    if (p.getSex() == Person.Sex.MAN) {
                        return age >= fromAge && age <= maleToAge;
                    } else {
                        return age >= fromAge && age <= femaleToAge;
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * Given a List of `Person` instances (having `name`, `age`, `sex` and `cats` fields),
     * return the names of all cats whose owners are women from `femaleAge` years old inclusively.
     */
    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        if (peopleList == null) {
            return Collections.emptyList();
        }
        return peopleList.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getSex() == Person.Sex.WOMAN)
                .filter(p -> p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(cat -> cat.getName())
                .collect(Collectors.toList());
    }

    /**
     * Validate candidates using CandidateValidator and return sorted names of valid candidates.
     */
    public List<String> validateCandidates(List<Candidate> candidates) {
        if (candidates == null) {
            return Collections.emptyList();
        }
        Predicate<Candidate> validator = new CandidateValidator();
        return candidates.stream()
                .filter(Objects::nonNull)
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
