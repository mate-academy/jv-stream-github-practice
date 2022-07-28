package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(f -> Integer.parseInt(f))
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(f -> f % 2 != 0 ? (numbers.get(f) - 1) : numbers.get(f))
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Can't get average value from list: "
                        + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {

        Predicate<Person> personPredicate = a -> fromAge < a.getAge() && a.getAge() <= toAge
                && a.getSex() == Person.Sex.MAN;

        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = p -> fromAge <= p.getAge() && p.getAge() <= maleToAge
                && p.getSex() == Person.Sex.MAN
                || fromAge <= p.getAge() && p.getAge() <= femaleToAge
                && p.getSex() == Person.Sex.WOMAN;

        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {

        Predicate<Person> personPredicate = w -> w.getSex() == Person.Sex.WOMAN
                && w.getAge() >= femaleAge;

        return peopleList.stream()
                .filter(personPredicate)
                .flatMap(p -> p.getCats().stream())
                .map(c -> c.getName())
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(c -> new CandidateValidator().test(c))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
