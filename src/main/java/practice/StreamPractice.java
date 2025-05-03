package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String separator = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream().map(number -> number.split(separator))
                .flatMap(list -> Arrays.stream(list).sorted())
                .mapToInt(Integer::valueOf)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(number -> number % 2 == 1 ? numbers.get(number) - 1 : numbers.get(number))
                .filter(number -> number % 2 == 1)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> testForSelectingManByAge(person, fromAge, toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person ->
                        testForGettingWorlablePeople(fromAge, femaleToAge, maleToAge, person))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> testForGettingCatNames(person, femaleAge))
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidate -> new CandidateValidator().test(candidate))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean testForSelectingManByAge(Person person, int fromAge, int toAge) {
        return person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }

    private boolean testForGettingWorlablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, Person person) {
        return person.getSex() == Person.Sex.MAN
                ? person.getAge() >= fromAge && person.getAge() <= maleToAge
                : person.getAge() >= fromAge && person.getAge() <= femaleToAge;
    }

    private boolean testForGettingCatNames(Person person, int femaleAge) {
        return person.getSex() == Person.Sex.WOMAN && person.getAge() >= femaleAge;
    }
}
