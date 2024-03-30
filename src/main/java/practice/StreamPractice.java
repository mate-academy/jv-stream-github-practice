package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;
import model.ValidPerson;

public class StreamPractice {
    private static final int MAX_TO_AGE = 200;
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(",")))
                .mapToInt(Integer::valueOf)
                .filter(num -> num % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min"
                        + " value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 == 1 ? numbers.get(index)
                        - 1 : numbers.get(index))
                .filter(num -> num % 2 == 1)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        ValidPerson validPerson = new ValidPerson(
                fromAge, toAge, Person.Sex.MAN
        );
        return peopleList.stream()
                .filter(validPerson)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(
            int fromAge,
            int femaleToAge,
            int maleToAge,
            List<Person> peopleList
    ) {
        ValidPerson menAgePredicate = new ValidPerson(
                fromAge,
                maleToAge,
                Person.Sex.MAN
        );
        ValidPerson womenAgePredicate = new ValidPerson(
                fromAge, femaleToAge, Person.Sex.WOMAN
        );
        return peopleList.stream()
                .filter(womenAgePredicate.or(menAgePredicate))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        ValidPerson validPerson = new ValidPerson(
                femaleAge, MAX_TO_AGE, Person.Sex.WOMAN
        );
        return peopleList.stream()
                .filter(validPerson)
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
