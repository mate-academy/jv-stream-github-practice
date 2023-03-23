package practice;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final int CHECK_FOR_EVEN = 2;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers
                .stream()
                .map(str -> List.of(str.split(",")))
                .flatMap(Collection::stream)
                .mapToInt(Integer::parseInt)
                .filter(num -> num % CHECK_FOR_EVEN == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list:"
                        + " < Here is our input 'numbers' >"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream
                .range(0, numbers.size())
                .map(index -> index % CHECK_FOR_EVEN == 0 ? numbers.get(index)
                        : numbers.get(index) - 1)
                .filter(num -> num % CHECK_FOR_EVEN == 1)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList
                .stream()
                .filter(person -> person.getAge() >= fromAge && person.getAge() <= toAge
                        && person.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList
                .stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        || (person.getAge() >= fromAge && person.getAge() <= femaleToAge))
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        || (person.getAge() >= fromAge && person.getAge() <= maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList
                .stream()
                .filter(person -> person.getAge() >= femaleAge
                        && person.getSex() == Person.Sex.WOMAN)
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
