package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(",")))
                .map(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new RuntimeException("Can't get min value from list" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return Stream.iterate(0, i -> i + 1)
                .limit(numbers.size())
                .map(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                .filter(num -> num % 2 != 0)
                .mapToDouble(n -> n)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge
                        && person.getAge() <= toAge
                        && person.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> (p.getAge() >= fromAge)
                        && ((p.getSex().equals(Person.Sex.MAN)
                        && p.getAge() <= maleToAge)
                        || (p.getSex() == Person.Sex.WOMAN
                        && p.getAge() <= femaleToAge)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN
                        && p.getCats().size() != 0
                        && p.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidate -> new CandidateValidator().test(candidate))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
