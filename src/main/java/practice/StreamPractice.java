package practice;

import java.util.Arrays;
import java.util.Collection;
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
                .map(s -> s.split(","))
                .flatMap(a -> Arrays.stream(a).sequential())
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
        Predicate<Person> ageFilter = person -> {
            int age = person.getAge();
            Person.Sex sex = person.getSex();
            if (sex == Person.Sex.MAN) {
                return (age >= fromAge) && (age <= maleToAge);
            } else {
                return (age >= fromAge) && (age <= femaleToAge);
            }
        };
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
