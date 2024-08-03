package practice;

import java.util.Arrays;
import java.util.Collection;
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
                .flatMap(s -> Arrays.stream((s.split(","))))
                .map(Integer::parseInt)
                .filter(s -> s % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {

        return IntStream.range(0, numbers.size())
                .mapToObj(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                .filter(num -> num % 2 != 0)
                .mapToDouble(num -> (double) num)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Can't get average from list: "
                        + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(s -> s.getAge() > fromAge
                        && s.getAge() <= toAge
                        && s.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(s -> (s.getAge() >= fromAge
                        && s.getAge() <= maleToAge
                        && s.getSex() == Person.Sex.MAN)
                        || (s.getAge() >= fromAge
                        && s.getAge() <= femaleToAge
                        && s.getSex() == Person.Sex.WOMAN))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(s -> s.getAge() >= femaleAge && s.getSex() == Person.Sex.WOMAN)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());

    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        Predicate<Candidate> candidatePredicate = new CandidateValidator();
        return candidates.stream()
                .filter(candidatePredicate)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
