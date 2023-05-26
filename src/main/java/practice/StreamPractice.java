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
    private static final String NUMBERS_SEPARATOR = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMapToInt(n -> Arrays.stream(n.split(NUMBERS_SEPARATOR))
                        .mapToInt(Integer::parseInt))
                .filter(s -> s % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(n -> n % 2 == 1 ? numbers.get(n) - 1 : numbers.get(n))
                .filter(n -> n % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> predicate = person -> person.getAge() >= fromAge
                && person.getAge() <= toAge
                && person.getSex() == Person.Sex.MAN;
        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicate = p -> p.getAge() >= fromAge
                && (p.getSex() == Person.Sex.WOMAN
                ? p.getAge() <= femaleToAge : p.getAge() <= maleToAge);
        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> predicate = p -> p.getSex() == Person.Sex.WOMAN
                && p.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(predicate)
                .map(Person::getCats)
                .flatMap(Collection::stream)
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
