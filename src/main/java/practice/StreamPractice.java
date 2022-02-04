package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        Supplier<RuntimeException> newRunTimeException = ()
                -> new RuntimeException("Can't get min value from list " + numbers);
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(newRunTimeException);
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        Supplier<NoSuchElementException> newNoSuchElementException = ()
                -> new NoSuchElementException("There is not odd elements in list: " + numbers);
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 != 0)
                .mapToDouble(Double::valueOf)
                .average()
                .orElseThrow(newNoSuchElementException);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> findManByAge = p -> p.getAge() >= fromAge
                && p.getAge() <= toAge
                && p.getSex().equals(Person.Sex.MAN);
        return peopleList.stream()
                .filter(findManByAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> findWomenAndMenByAge = p -> p.getAge() >= fromAge
                && (p.getSex().equals(Person.Sex.MAN) && p.getAge() <= maleToAge
                || p.getSex().equals(Person.Sex.WOMAN) && p.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(findWomenAndMenByAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> findWomenByAge = p -> p.getSex().equals(Person.Sex.WOMAN)
                && p.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(findWomenByAge)
                .flatMap(l -> l.getCats().stream())
                .map(Cat::getName)
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
