package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")).sequential())
                .mapToInt(Integer::valueOf)
                .filter(n -> (n % 2 == 0))
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(n -> (n % 2 == 1) ? (numbers.get(n) - 1) : numbers.get(n))
                .filter(n -> (n % 2 == 1))
                .mapToDouble(n -> n)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> manAgeFilter = person ->
                (person.getSex() == Person.Sex.MAN)
                        && (person.getAge() >= fromAge)
                        && (person.getAge() <= toAge);
        return peopleList.stream()
                .filter(manAgeFilter)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> ageFilter = person -> (person.getSex() == Person.Sex.MAN)
                ? (fromAge <= person.getAge()) && (person.getAge() <= maleToAge)
                : (fromAge <= person.getAge()) && (person.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(ageFilter)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> womanAgeFilter = person ->
                (person.getSex() == Person.Sex.WOMAN)
                        && (person.getAge() >= femaleAge)
                        && !person.getCats().isEmpty();
        return peopleList.stream()
                .filter(womanAgeFilter)
                .flatMap(person -> person.getCats().stream())
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
