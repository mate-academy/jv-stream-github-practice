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

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 == 1)
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() ->
                        new NoSuchElementException("No such element in this: " + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> getMenByAgePredicate = person ->
                person.getSex().equals(Person.Sex.MAN)
                && person.getAge() >= fromAge && person.getAge() <= toAge;
        return peopleList.stream()
                .filter(getMenByAgePredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> getWorcablePeoplesPredicate = person ->
                    person.getSex().equals(Person.Sex.MAN)
                    && person.getAge() >= fromAge && person.getAge() <= maleToAge
                    || person.getSex().equals(Person.Sex.WOMAN)
                    && person.getAge() >= fromAge && person.getAge() <= femaleToAge;
        return peopleList.stream()
                .filter(getWorcablePeoplesPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> getWomanByAgeAndHaveCatPredicate = person ->
                person.getSex().equals(Person.Sex.WOMAN)
                    && person.getAge() >= femaleAge
                    && !person.getCats().isEmpty();
        return peopleList.stream()
                .filter(getWomanByAgeAndHaveCatPredicate)
                .flatMap(female -> female.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
