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
                .flatMapToInt(e -> Arrays.stream(e.split(","))
                        .mapToInt(Integer::parseInt))
                .filter(e -> e % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }
    
    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(num -> num % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException("No elements in the list."));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> isManInRange = person ->
                person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= toAge;

        return peopleList.stream()
                .filter(isManInRange)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> isMaleInRange = p -> p.getSex() == Person.Sex.MAN
                && p.getAge() >= fromAge && p.getAge() <= maleToAge;

        Predicate<Person> isFemaleInRange = p -> p.getSex() == Person.Sex.WOMAN
                && p.getAge() >= fromAge && p.getAge() <= femaleToAge;

        return peopleList.stream()
                .filter(isMaleInRange.or(isFemaleInRange))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN
                        && p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
