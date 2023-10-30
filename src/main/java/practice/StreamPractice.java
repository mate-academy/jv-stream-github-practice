package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String MIN_VALUE_NOT_FOUND = "Can't get min value from list: ";
    private static final String MARK_COMMA = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(split -> split.split(MARK_COMMA))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException(MIN_VALUE_NOT_FOUND + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> (i % 2 == 1) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 != 0)
                .mapToDouble(i -> i)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge)
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() <= femaleToAge
                        || person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
