package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public static final String COMA_SEPARATOR = ",";
    public static final int DIVISION_CONSTANT = 2;
    public static final int SUBTRACTOR = 1;
    private final Predicate<Integer> checkNumIsOdd = n -> n % DIVISION_CONSTANT != 0;

    public int findMinEvenNumber(List<String> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new RuntimeException("Can't get min value from list: " + numbers);
        }
        return numbers
                .stream()
                .map(s -> s.split(COMA_SEPARATOR))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(n -> !checkNumIsOdd.test(n))
                .min()
                .orElseThrow(()
                        -> new RuntimeException("Can't get min value from list: " + numbers));

    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0D;
        }
        return IntStream.range(0, numbers.size())
                .map(i -> checkNumIsOdd.test(i) ? numbers.get(i) - SUBTRACTOR : numbers.get(i))
                 .filter(checkNumIsOdd::test)
                 .average()
                 .getAsDouble();

    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> checkManAge = (p)
                -> p.getSex() == Person.Sex.MAN && p.getAge() >= fromAge && p.getAge() <= toAge;
        if (peopleList == null || peopleList.isEmpty()) {
            return Collections.emptyList();
        }
        return peopleList
                .stream()
                .filter(checkManAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        if (peopleList == null || peopleList.isEmpty()) {
            return Collections.emptyList();
        }
        Predicate<Person> workingAge = p -> p.getAge() >= fromAge
                && (p.getSex() == Person.Sex.MAN ? p.getAge() <= maleToAge
                : p.getAge() <= femaleToAge);
        return peopleList
                .stream()
                .filter(workingAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        if (peopleList == null || peopleList.isEmpty()) {
            return Collections.emptyList();
        }
        Predicate<Person> womanHasCat = p -> p.getAge() >= femaleAge
                && p.getSex() == Person.Sex.WOMAN && !p.getCats().isEmpty();
        return peopleList
                .stream()
                .filter(womanHasCat)
                 .map(Person::getCats)
                 .flatMap(Collection::stream)
                  .map(Cat::getName)
                  .collect(Collectors.toList());

    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        if (candidates == null || candidates.isEmpty()) {
            return Collections.emptyList();
        }

        return candidates
                .stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

}
