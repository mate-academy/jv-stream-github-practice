package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;
import model.Person.Sex;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
            .map(string -> string.split(","))
        .flatMap(Arrays::stream)
        .mapToInt(Integer::parseInt)
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
        .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
            .filter(person -> personManFromAgeToAge(person, fromAge, toAge))
        .collect(Collectors.toList());
    }

    private boolean personManFromAgeToAge(Person person, int fromAge, int toAge) {
        return checkAge(fromAge, person, toAge)
            && (person.getSex() == Sex.MAN);
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
            int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
        .filter(person -> peopleManAndWomanFromToAge(fromAge, person, femaleToAge, maleToAge))
        .collect(Collectors.toList());
    }

    private boolean peopleManAndWomanFromToAge(int fromAge, Person person,
            int femaleToAge, int maleToAge) {
        return person.getSex() == Sex.MAN
            ? checkAge(fromAge, person, maleToAge)
            : checkAge(fromAge, person, femaleToAge);
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
        .filter(person -> personWomanAgeFrom(person, femaleAge))
        .map(Person::getCats)
        .flatMap(Collection::stream)
        .map(Cat::getName)
        .collect(Collectors.toList());
    }

    private boolean personWomanAgeFrom(Person person, int femaleAge) {
        return (person.getAge() >= femaleAge)
            && (person.getCats() != null)
            && (person.getSex() == Sex.WOMAN);
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
        .filter(new CandidateValidator())
        .map(Candidate::getName)
        .sorted()
        .collect(Collectors.toList());
    }

    private boolean checkAge(int fromAge, Person person, int toAge) {
        return person.getAge() >= fromAge && person.getAge() <= toAge;
    }
}
