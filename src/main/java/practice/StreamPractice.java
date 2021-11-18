package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min().orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        return numbers.stream()
                .map(n -> (atomicInteger.getAndIncrement() % 2 == 0 ? n : n - 1))
                .filter(n -> n % 2 == 1)
                .mapToDouble(n -> n)
                .average().orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN)
                .filter(p -> p.getAge() <= toAge && p.getAge() >= fromAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> man = p -> p.getSex() == Person.Sex.MAN && p.getAge() <= maleToAge;
        Predicate<Person> woman = p -> p.getSex() == Person.Sex.WOMAN && p.getAge() <= femaleToAge;
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge)
                .filter(man.or(woman))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= femaleAge && p.getSex() == Person.Sex.WOMAN)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        Predicate<Candidate> candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
