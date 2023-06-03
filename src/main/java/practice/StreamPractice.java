package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(stringLine -> (stringLine.split(",")))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min().orElseThrow(() ->
                        new RuntimeException("Can't get min value from list:"
                                + " < Here is our input 'numbers' >"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {

        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(number -> number % 2 != 0)
                .average().orElseThrow(() ->
                        new NoSuchElementException("Can't get average of all odd "
                                + "numbers from list"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(isRecrut -> isRecrut.getSex() == Person.Sex.MAN
                        && isRecrut.getAge() >= fromAge && isRecrut.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge,
                                          List<Person> peopleList) {
        return peopleList.stream()
                .filter(person ->
                        (person.getSex() == Person.Sex.MAN
                                && person.getAge() >= fromAge
                                && person.getAge() <= maleToAge)
                                || (person.getSex() == Person.Sex.WOMAN
                                && person.getAge() >= fromAge
                                && person.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {

        return peopleList.stream()
                .filter((person ->
                        (person != null
                                && person.getSex() == Person.Sex.WOMAN
                                && person.getAge() > femaleAge)))
                .filter(Objects::nonNull)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(cat -> cat != null
                        && cat.getName() != null ? cat.getName() : "")
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(Objects::nonNull)
                .filter(candidateValidator::test)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
