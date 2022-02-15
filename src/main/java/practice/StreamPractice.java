package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
                .min(Integer::compareTo)
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream
                .range(0, numbers.size())
                .map(index -> index % 2 != 0
                        ? numbers.get(index) - 1
                        : numbers.get(index))
                .filter(n -> n % 2 != 0)
                .average()
                .getAsDouble();
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
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
