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
    public static final String COMMA_REGEX = ",";

    public int findMinEvenNumber(List<String> numbers) {
        Predicate<Integer> evenPredicate = i -> i % 2 == 0;
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(COMMA_REGEX)))
                .map(Integer::parseInt)
                .filter(evenPredicate)
                .mapToInt(Integer::valueOf)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        AtomicInteger index = new AtomicInteger();
        Predicate<Integer> oddNumberPredicate = n -> n % 2 != 0;
        return numbers.stream()
                .map(n -> {
                    if (index.get() % 2 != 0) {
                        n = n - 1;
                    }
                    index.getAndIncrement();
                    return n;
                })
                .filter(oddNumberPredicate)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> armyPredicate =
                p -> p.getSex().equals(Person.Sex.MAN)
                && p.getAge() >= fromAge
                && p.getAge() <= toAge;
        return peopleList.stream()
                .filter(armyPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> workPredicate = p -> {
            if (p.getSex().equals(Person.Sex.MAN)) {
                return p.getAge() >= fromAge && p.getAge() <= maleToAge;
            } else if (p.getSex().equals(Person.Sex.WOMAN)) {
                return p.getAge() >= fromAge && p.getAge() <= femaleToAge;
            }
            return false;
        };
        return peopleList.stream()
                .filter(workPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> personPredicate = p ->
                p.getSex().equals(Person.Sex.WOMAN)
                && p.getAge() >= femaleAge
                && !p.getCats().isEmpty();
        return peopleList.stream()
                .filter(personPredicate)
                .flatMap(p -> p.getCats()
                        .stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
