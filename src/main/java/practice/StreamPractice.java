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
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: method_input_list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> (i % 2 != 0) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException("No odd numbers were found!"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(isMaleInAgeRange(fromAge, toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(isMaleAndFemaleInAgeRange(fromAge, femaleToAge, maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN && p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
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

    private Predicate<Person> isMaleInAgeRange(int fromAge, int toAge) {
        return p -> p.getSex() == Person.Sex.MAN && p.getAge() > fromAge && p.getAge() <= toAge;
    }

    private Predicate<Person> isMaleAndFemaleInAgeRange(int fromAge, int femaleToAge,
                                                  int maleToAge) {
        return p -> (p.getSex() == Person.Sex.MAN
                ? fromAge <= p.getAge() && p.getAge() <= maleToAge
                : fromAge <= p.getAge() && p.getAge() <= femaleToAge);
    }
}
