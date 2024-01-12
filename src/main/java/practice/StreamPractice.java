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
    private static final String REGEX_TO_CHECK_WHETHER_NUMBER = "-?\\d+";
    private static final int NUMBER_TO_SUBTRACT = 1;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers
                .stream()
                .flatMap(string -> Arrays.stream(string.split(COMMA)))
                .filter(string -> string.matches(REGEX_TO_CHECK_WHETHER_NUMBER))
                .mapToInt(Integer::parseInt)
                .filter(integer -> integer % 2 == 0)
                .min().orElseThrow(() -> new NoSuchElementException(
                        "Can't get min value from list: < Here is our input 'numbers' >"
                                + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        IntStream
                .range(0, numbers.size())
                .filter(i -> i % 2 != 0)
                .forEach(index -> numbers.set(index, numbers.get(index) - NUMBER_TO_SUBTRACT));
        return numbers
                .stream()
                .filter(integer -> integer % 2 != 0)
                .mapToDouble(Double::valueOf)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList
                .stream()
                .filter(person -> person.getSex().equals(Person.Sex.MAN)
                            && person.getAge() >= fromAge
                            && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList
                .stream()
                .filter(person -> (person.getSex().equals(Person.Sex.MAN))
                        ? (person.getAge() >= fromAge && person.getAge() <= maleToAge)
                        : (person.getAge() >= fromAge && person.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList
                .stream()
                .filter(person -> person.getSex().equals(Person.Sex.WOMAN)
                        && person.getCats() != null
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats()
                        .stream()
                        .map(Cat::getName))
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates
                .stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
