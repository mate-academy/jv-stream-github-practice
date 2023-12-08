package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
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
                .map(s -> s.split(","))
                .flatMap(Arrays::stream).map(Integer::parseInt)
                .filter(s -> s % 2 == 0)
                .min(Comparator.comparingInt(a -> a))
                .orElseThrow(() -> new RuntimeException("Can't get min value from list:"
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(s -> s % 2 != 0 ? numbers.get(s) - 1 : numbers.get(s))
                .filter(s -> s % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(s -> s.getAge() >= fromAge && s.getAge() <= toAge
                        && s.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(s -> s.getSex() == Person.Sex.MAN && s.getAge() >= fromAge
                        && s.getAge() <= maleToAge || s.getSex() == Person.Sex.WOMAN
                        && s.getAge() >= fromAge
                        && s.getAge() <= femaleToAge).collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream().filter(s -> s.getSex() == Person.Sex.WOMAN
                        && s.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(s -> new CandidateValidator().test(s))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
