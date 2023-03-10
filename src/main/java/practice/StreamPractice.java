package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        OptionalInt first = numbers.stream()
                .flatMap(n -> Arrays.stream(n.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min();
        return first.orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        OptionalDouble average = IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i)).filter(i -> i % 2 != 0)
                .average();
        return average.orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream().filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= fromAge && person.getAge() <= femaleToAge
                        || person.getSex() == Person.Sex.MAN && person.getAge()
                        >= fromAge && person.getAge() <= maleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .map(Person::getCats).flatMap(Collection::stream).map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator validator = new CandidateValidator();
        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
