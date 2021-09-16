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
                 .flatMap(subString -> Arrays.stream(subString.split(",")))
                 .map(Integer::parseInt)
                 .filter(evenNum -> evenNum % 2 == 0)
                 .min(Integer::compareTo)
                 .orElseThrow(() ->
                         new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(number -> number % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> filterMan = person -> person.getAge() >= fromAge
                && person.getAge() <= toAge
                && person.getSex().equals(Person.Sex.MAN);
        return peopleList.stream()
                .filter(filterMan)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> filterPeople = person -> person.getAge() >= fromAge
                && ((person.getAge() <= maleToAge
                && person.getSex().equals(Person.Sex.MAN))
                || person.getAge() <= femaleToAge
                && person.getSex().equals(Person.Sex.WOMAN));
        return peopleList.stream()
                .filter(filterPeople)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> filterPeople = person -> person.getAge() >= femaleAge
                && person.getSex().equals(Person.Sex.WOMAN);
        return peopleList.stream()
                .filter(filterPeople)
                .flatMap(name -> name.getCats().stream())
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
