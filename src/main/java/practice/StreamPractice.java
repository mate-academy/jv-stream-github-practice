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
    private static final String NUMBER_SEPARATOR = ",";
    private static final int DECREMENT = 1;
    private static final CandidateValidator CANDIDATE_VALIDATOR = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(NUMBER_SEPARATOR)))
                .mapToInt(Integer::parseInt)
                .filter(integer -> integer % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list:"
                        + " method_input_list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0 ? numbers.get(index) - DECREMENT : numbers.get(index))
                .filter(number -> number % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> predicateMan = person -> person != null
                && person.getSex().equals(Person.Sex.MAN)
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
        return peopleList.stream()
                .filter(predicateMan)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicateMan = person -> person != null
                && person.getAge() >= fromAge
                && (person.getSex().equals(Person.Sex.MAN) && person.getAge() <= maleToAge
                || person.getSex().equals(Person.Sex.WOMAN) && person.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(predicateMan)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> predicate = person -> person.getSex().equals(Person.Sex.WOMAN)
                && person.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(predicate)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(CANDIDATE_VALIDATOR)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
