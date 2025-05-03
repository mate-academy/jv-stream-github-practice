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
                .flatMap(str -> Arrays.stream(str.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(i -> (i % 2 != 0) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(number -> number % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Can't get average "
                        + "of all odd numbers from the list: "
                        + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN && person.getAge()
                        >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        PredicateAgePersonImpl predicate = new PredicateAgePersonImpl();
        return peopleList.stream()
                .filter(person -> predicate.test(fromAge, femaleToAge, maleToAge, person))
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
                    .filter(new CandidateValidator())
                    .map(Candidate::getName)
                    .sorted()
                    .toList();
    }
}
