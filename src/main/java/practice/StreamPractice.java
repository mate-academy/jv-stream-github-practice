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
    private static final String NUMBERS_SEPARATOR = ",";
    private final Predicate<Integer> isOddNumber = n -> n % 2 != 0;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream().map(s -> s.split(NUMBERS_SEPARATOR))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(n -> !isOddNumber.test(n))
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> isOddNumber.test(i) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(isOddNumber)
                .mapToInt(Integer::valueOf)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> personPredicate = person -> person.getAge() >= fromAge
                && person.getAge() <= toAge
                && person.getSex().equals(Person.Sex.MAN);
        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = person -> person.getSex().equals(Person.Sex.WOMAN)
                && person.getAge() >= fromAge
                && person.getAge() <= femaleToAge
                || person.getSex().equals(Person.Sex.MAN)
                && person.getAge() >= fromAge && person.getAge() <= maleToAge;
        return peopleList.stream()
                .filter(personPredicate)
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
                .collect(Collectors.toList());
    }
}
