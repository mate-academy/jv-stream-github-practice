package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(str -> Arrays.stream(str.split(",")))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .min(Integer::compare)
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> modifiedNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 != 0) {
                modifiedNumbers.add(numbers.get(i) - 1);
            } else {
                modifiedNumbers.add(numbers.get(i));
            }
        }

        List<Integer> oddNumbers = modifiedNumbers.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());

        if (oddNumbers.isEmpty()) {
            throw new NoSuchElementException();
        }

        return oddNumbers.stream().mapToInt(Integer::intValue).average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList,
                                       int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN)
                .filter(person -> person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> {
                    if (person.getSex() == Person.Sex.MAN) {
                        return person.getAge() >= fromAge
                                && person.getAge() <= maleToAge;
                    } else {
                        return person.getAge() >= fromAge
                                && person.getAge() <= femaleToAge;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex()
                        == Person.Sex.WOMAN && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        Predicate<Candidate> validator = new CandidateValidator();
        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
