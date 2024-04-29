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
    public static final String SEPARATOR = ",";

    public int findMinEvenNumber(List<String> numbers) {
        List<Integer> parsedFilteredNumbers = numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(SEPARATOR)))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .toList();

        if (parsedFilteredNumbers.isEmpty()) {
            throw new RuntimeException("Can't get min value from list: " + numbers);
        }

        return parsedFilteredNumbers.stream().min(Integer::compareTo).orElseThrow();
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        IntStream.range(0, numbers.size())
                .filter(i -> i % 2 != 0)
                .forEach(i -> numbers.set(i, numbers.get(i) - 1));

        return numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Can't get min value from list: "
                        + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> {
                    int age = person.getAge();
                    if (person.getSex() == Person.Sex.MAN) {
                        return age >= fromAge && age <= maleToAge;
                    } else {
                        return age >= fromAge && age <= femaleToAge;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream().map(Cat::getName))
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator validator = new CandidateValidator();
        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
