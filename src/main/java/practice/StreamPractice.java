package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static String REGEX = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers
                .stream()
                .flatMap(s -> Arrays.stream(s.split(REGEX)))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list:"
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 != 0)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> predicate = person -> Person.Sex.MAN == person.getSex()
                && person.getAge() >= fromAge && person.getAge() <= toAge;
        return peopleList
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList
                .stream()
                .filter(new WorkablePeopleValidator(fromAge, maleToAge, femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> predicate = person -> person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge;
        return peopleList
                .stream()
                .filter(predicate)
                .flatMap(person -> person.getCats().stream().map(Cat::getName))
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
