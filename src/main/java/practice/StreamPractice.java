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
    private Predicate<Candidate> validatorCandidate = new CandidateValidator();
    private Predicate<Person> validatorPerson = new PersonValidator(0, 0, 0);

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(number -> Arrays.stream(number.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(number -> (number % 2 != 0 ? numbers.get(number) - 1 : numbers.get(number)))
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException(
                        "No one odd number was found in the list"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        validatorPerson = new PersonValidator(fromAge, femaleToAge, maleToAge);
        return peopleList.stream()
                .filter(validatorPerson)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(validatorCandidate)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
