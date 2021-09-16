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
        return peopleList.stream()
                .filter(person -> filterMan(person, fromAge, toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter((person -> filterMan(person, fromAge, maleToAge)
                        || filterWoman(person, fromAge, femaleToAge)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> filterWoman(person, femaleAge, Integer.MAX_VALUE))
                .flatMap(name -> name.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    private boolean filterMan(Person person, int maleFromAge, int maleToAge) {
        return person.getAge() >= maleFromAge
                && person.getAge() <= maleToAge
                && person.getSex().equals(Person.Sex.MAN);
    }

    private boolean filterWoman(Person person, int femaleFromAge, int femaleToAge) {
        return person.getAge() >= femaleFromAge
                && person.getAge() <= femaleToAge
                && person.getSex().equals(Person.Sex.WOMAN);
    }
}
