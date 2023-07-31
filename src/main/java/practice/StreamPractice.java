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
    public int findMinEvenNumber(List<String> numbers) {
        List<Integer> integers = numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(Integer::parseInt)
                .filter(this::isEven)
                .collect(Collectors.toList());
        if (integers.isEmpty()) {
            throw new RuntimeException("Can't get min value from list: " + numbers);
        }
        return integers.stream()
                .min(Integer::compare)
                .get();
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> isEven(index) ? numbers.get(index) : numbers.get(index) - 1)
                .filter(index -> !isEven(index))
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN)
                .filter(person -> person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        ? person.getAge() >= fromAge && person.getAge() <= maleToAge
                        : person.getAge() >= fromAge && person.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN)
                .filter(person -> person.getAge() >= femaleAge)
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

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
