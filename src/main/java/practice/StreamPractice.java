package practice;

import static practice.CandidateValidator.isValidCandidate;

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
    private static final String SPLITTER = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                      .map(n -> n.split(SPLITTER))
                      .flatMap(Arrays::stream)
                      .mapToInt(Integer::parseInt)
                      .filter(n -> n % 2 == 0)
                      .min()
                      .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                                                              + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                        .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                        .filter(n -> n % 2 != 0)
                        .average()
                        .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                         .filter(p -> Person.Sex.MAN.equals(p.getSex()) && p.getAge() >= fromAge
                                 && p.getAge() <= toAge)
                         .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                         .filter(p -> (Person.Sex.MAN.equals(p.getSex())
                                 && p.getAge() >= fromAge && p.getAge() <= maleToAge)
                                 || (Person.Sex.WOMAN.equals(p.getSex())
                                 && p.getAge() >= fromAge && p.getAge() <= femaleToAge))
                         .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                         .filter(p -> Person.Sex.WOMAN.equals(p.getSex())
                                 && p.getAge() >= femaleAge)
                         .map(Person::getCats)
                         .flatMap(Collection::stream)
                         .map(Cat::getName)
                         .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                         .filter(isValidCandidate)
                         .map(Candidate::getName)
                         .sorted()
                         .collect(Collectors.toList());
    }
}
