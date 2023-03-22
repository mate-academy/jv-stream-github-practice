package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Collection;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public static int findMinEvenNumber(List<String> numbers) {
        OptionalInt n = numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(Integer::valueOf)
                .filter(i -> i % 2 == 0)
                .mapToInt(i -> i)
                .min();
        return n.orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                + "< Here is our input 'numbers' >"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 != 0) {
                numbers.set(i, numbers.get(i) - 1);
            }
        }
        OptionalDouble optionalDouble = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(l -> l)
                .average();
        return optionalDouble.orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> personPredicate = p -> p.getSex().equals(Person.Sex.MAN)
                && p.getAge() >= fromAge
                && p.getAge() <= toAge;

        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = p -> (p.getSex().equals(Person.Sex.MAN)
                && p.getAge() >= fromAge
                && p.getAge() <= maleToAge)
                || (p.getSex().equals(Person.Sex.WOMAN)
                && p.getAge() >= fromAge
                && p.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.WOMAN) && p.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator::test)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
