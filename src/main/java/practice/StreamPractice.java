package practice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(line -> java.util.Arrays.stream(line.split(",")))
                .map(String::trim)
                .map(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return java.util.stream.IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0
                        ? numbers.get(index) - 1
                        : numbers.get(index))
                .filter(number -> number % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList,
                                       int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> Person.Sex.MAN.equals(person.getSex()))
                .filter(person -> person.getAge() >= fromAge
                        && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge,
                                          List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge)
                .filter(person -> Person.Sex.MAN.equals(person.getSex())
                        ? person.getAge() <= maleToAge
                        : person.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList,
                                     int femaleAge) {
        return peopleList.stream()
                .filter(person -> Person.Sex.WOMAN.equals(person.getSex()))
                .filter(person -> person.getAge() >= femaleAge)
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
