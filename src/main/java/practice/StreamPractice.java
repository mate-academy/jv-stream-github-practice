package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private final CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(",")))
                .map(Integer::parseInt)
                .filter(number -> !isOddNumber(number))
                .min(Integer::compare)
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(iterator -> iterator % 2 != 0 ? numbers.get(iterator) - 1
                        : numbers.get(iterator))
                .filter(number -> isOddNumber(number))
                .average()
                .orElseThrow(() ->
                        new NoSuchElementException("Cannot calculate average of oddNumbers"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> isValidMan(person, fromAge, toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(people -> isWorkable(people, fromAge, maleToAge, femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> isValidWomen(person, femaleAge))
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator)
                .sorted(Comparator.comparing(Candidate::getName))
                .map(Candidate::getName)
                .collect(Collectors.toList());
    }

    private boolean isValidMan(Person person, int fromAge, int toAge) {
        return person.getSex() == Person.Sex.MAN
                && person.getAge() > fromAge
                && person.getAge() <= toAge;
    }

    private boolean isWorkable(Person person, int fromAge, int maleToAge, int femaleToAge) {
        return person.getAge() >= fromAge
                && (person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge
                || person.getSex() == Person.Sex.WOMAN && person.getAge() <= femaleToAge);
    }

    private boolean isValidWomen(Person person, int femaleAge) {
        return person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge;
    }

    private boolean isOddNumber(int number) {
        return Math.abs(number) % 2 == 1;
    }
}
