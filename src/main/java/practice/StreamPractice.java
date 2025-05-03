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
        return numbers
                .stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream
                .range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 != 0)
                .average()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't get average value from list: "
                                + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> personCanBeRecruited = p -> p.getSex().equals(Person.Sex.MAN)
                && p.getAge() >= fromAge && p.getAge() <= toAge;
        return peopleList
                .stream()
                .filter(personCanBeRecruited)
        .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> workablePersonPredicate = p -> p.getAge() >= fromAge
                && (p.getSex().equals(Person.Sex.MAN)
                ? p.getAge() <= maleToAge : p.getAge() <= femaleToAge);
        return peopleList
                .stream()
                .filter(workablePersonPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> ownersWomenPredicate = p -> p.getSex().equals(Person.Sex.WOMAN)
                && p.getAge() >= femaleAge;
        return peopleList
                .stream()
                .filter(ownersWomenPredicate)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates
                .stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
