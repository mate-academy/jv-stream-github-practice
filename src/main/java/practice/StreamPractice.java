package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        Optional<Integer> min = numbers.stream()
                .flatMap(i -> Arrays.stream(i.split(",")))
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min(Integer::compare);
        return min.orElseThrow(() ->
                new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        OptionalDouble average = IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? (numbers.get(i) - 1) : numbers.get(i))
                .filter(n -> n % 2 != 0)
                .average();
        return average.orElseThrow(() ->
                new NoSuchElementException("Can`t get average value from list: " + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge
                        &&
                        p.getAge() <= toAge
                        &&
                        p.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        &&
                        p.getAge() >= fromAge
                        &&
                        p.getAge() <= maleToAge
                        ||
                        p.getSex() == Person.Sex.WOMAN
                                &&
                                p.getAge() >= fromAge
                                &&
                                p.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN
                        &&
                        p.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(c -> new CandidateValidator().test(c))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
