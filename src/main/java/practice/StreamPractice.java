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
    private static final CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(el -> el.split(","))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .filter(el -> el % 2 == 0)
                .min(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Can't get min value from list:"
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> modifiedList = IntStream.range(0,numbers.size())
                .mapToObj(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .toList();

        return modifiedList.stream()
                .filter(el -> el % 2 != 0)
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge
                        && ((person.getSex() == Person.Sex.MAN
                              && person.getAge() <= maleToAge)
                           || (person.getSex() == Person.Sex.WOMAN
                              && person.getAge() <= femaleToAge)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= femaleAge
                        && person.getSex() == Person.Sex.WOMAN)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator::test)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
