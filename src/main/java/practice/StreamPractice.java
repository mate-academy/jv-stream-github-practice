package practice;

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
                .flatMap(str -> List.of(str.split(",")).stream())
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .sorted()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list:"
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return numbers.stream()
                .map(i -> (numbers.indexOf(i) % 2 == 1) ? i - 1 : i)
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("No odd numbers in the list"));
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
                .filter(person ->
                        (person.getSex() == Person.Sex.MAN && person.getAge() >= fromAge
                                && person.getAge() <= maleToAge)
                                || (person.getSex() == Person.Sex.WOMAN
                                && person.getAge() >= fromAge
                                && person.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getCats() != null
                        && person.getAge() >= femaleAge)
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
