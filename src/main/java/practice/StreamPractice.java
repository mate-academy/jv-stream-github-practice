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
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::valueOf)
                .filter(num -> num % 2 == 0)
                .map(i -> (i % 2 == 1) ? i - 1 : i)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get "
                        + "min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(i -> (i % 2 == 1) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(num -> num % 2 == 1)
                .average()
                .orElseThrow(() -> new NoSuchElementException("No odd numbers found."));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge,
                                          List<Person> peopleList) {
        Predicate<? super Person> workablePredicate = person ->
                person.getSex() == Person.Sex.MAN
                        ? (person.getAge() >= fromAge && person.getAge() <= maleToAge)
                        : (person.getSex() == Person.Sex.WOMAN && person.getAge() >= fromAge
                        && person.getAge() <= femaleToAge);

        return peopleList.stream()
                .filter(workablePredicate)
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
        CandidateValidator candidateValidator = new CandidateValidator();

        return candidates.stream()
                .filter(candidate -> candidateValidator.test(candidate))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
