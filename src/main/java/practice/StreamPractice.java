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
                .map(p -> p.split(","))
                .flatMapToInt(a -> Arrays.stream(a)
                        .mapToInt(Integer::parseInt))
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                .filter(i -> i % 2 == 1)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> personPredicate = person ->
                person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = person ->
                person.getAge() >= fromAge
                && ((person.getSex() == Person.Sex.MAN
                && person.getAge() <= maleToAge)
                || (person.getSex() == Person.Sex.WOMAN
                && person.getAge() <= femaleToAge));
        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> personPredicate = person ->
                person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(personPredicate)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        Predicate<Candidate> candidatePredicate = new CandidateValidator();
        return candidates.stream()
                .filter(candidatePredicate)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
