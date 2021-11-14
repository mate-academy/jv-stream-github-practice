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
        return numbers.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min(Integer::compare)
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: "
                                + numbers));

    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(n -> n % 2 == 1 ? numbers.get(n) - 1 : numbers.get(n))
                .filter(n -> n % 2 == 1)
                .average()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't do this for list: "
                                + numbers));

    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge
                        && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge
                        && p.getSex() == Person.Sex.MAN && p.getAge() <= maleToAge
                        || p.getSex() == Person.Sex.WOMAN && p.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN
                        && p.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
