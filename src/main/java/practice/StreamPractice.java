package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
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
                .distinct()
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min().orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream
                .range(0, numbers.size())
                .map(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(x -> x % 2 == 1)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList
                .stream()
                .filter(m -> m.getSex().equals(Person.Sex.MAN)
                        && m.getAge() >= fromAge && m.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList
                .stream()
                .filter(m -> (m.getSex().equals(Person.Sex.MAN)
                        && m.getAge() >= fromAge && m.getAge() <= maleToAge)
                        || (m.getSex().equals(Person.Sex.WOMAN)
                        && m.getAge() >= fromAge && m.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList
                .stream()
                .filter(w -> w.getAge() >= femaleAge && w.getSex().equals(Person.Sex.WOMAN))
                .map(Person::getCats)
                .flatMap(Collection::stream)
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
