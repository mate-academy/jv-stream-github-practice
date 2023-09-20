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
        List<Integer> evenNumbers = numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        if (evenNumbers.isEmpty()) {
            throw new RuntimeException("Can't get min value from list: " + numbers);
        }

        return evenNumbers.stream()
                .min(Integer::compareTo)
                .orElseThrow(()
                        -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> modifiedNumbers = IntStream.range(0, numbers.size())
                .mapToObj(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                .collect(Collectors.toList());

        List<Integer> oddNumbers = modifiedNumbers.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());

        if (oddNumbers.isEmpty()) {
            throw new NoSuchElementException("No odd numbers found in the list.");
        }

        return oddNumbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("No odd numbers found in the list."));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge,
                                          int femaleToAge,
                                          int maleToAge,
                                          List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> (person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= fromAge
                        && person.getAge() <= femaleToAge)
                            || (person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge
                        && person.getAge() <= maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator()::test)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
