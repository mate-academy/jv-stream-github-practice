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
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(",")))
                .map(Integer::valueOf)
                .filter(number -> !isOdd(number))
                .min(Integer::compare)
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: < Here is our input 'numbers' >"
                ));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> isOdd(index) ? numbers.get(index) - 1 : numbers.get(index))
                .filter(this::isOdd)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean isOdd(Integer number) {
        return number % 2 != 0;
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> isValidAge(person, Person.Sex.MAN, fromAge, toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> isValidAge(person, Person.Sex.MAN, fromAge, maleToAge)
                                || isValidAge(person, Person.Sex.WOMAN, fromAge, femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person ->
                        (isValidAge(person, Person.Sex.WOMAN, femaleAge, Integer.MAX_VALUE)))
                .flatMap(woman -> woman.getCats().stream())
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

    private boolean isValidAge(Person person, Person.Sex sex, int fromAge, int toAge) {
        return person.getSex() == sex
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }
}
