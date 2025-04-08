package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private final CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {

        return numbers.stream()
                .map(n -> n.split(","))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        AtomicInteger index = new AtomicInteger();
        return IntStream
                .range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(num -> num % 2 != 0)
                .mapToDouble(Double::valueOf)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge
                        && p.getAge() <= toAge
                        && p.getSex() == Person.Sex.MAN)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = person -> {
            return person.getAge() >= fromAge
                    && ((person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge)
                    || (person.getSex() == Person.Sex.WOMAN
                    && person.getAge() <= femaleToAge));
        };

        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> womenOwnersCatsFromFemaleAge = person ->
                person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge;

        return peopleList.stream()
                .filter(womenOwnersCatsFromFemaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
