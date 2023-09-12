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
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(line -> Arrays.stream(line.split(",")))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 == 1)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> personPredicate = person ->
                person.getSex() == Person.Sex.MAN
                        && person.getAge() > fromAge
                        && person.getAge() <= toAge;

        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = person ->
                person.getSex() == Person.Sex.MAN
                        ? person.getAge() >= fromAge && person.getAge() <= maleToAge
                        : person.getAge() >= fromAge && person.getAge() <= femaleToAge;

        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> personPredicate = person ->
                person.getSex() == Person.Sex.WOMAN
                        && !person.getCats().isEmpty()
                        && person.getAge() >= femaleAge;

        return peopleList.stream()
                .filter(personPredicate)
                .flatMap(p -> p.getCats().stream())
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
