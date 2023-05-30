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

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(NUMBERS_SEPARATOR)))
                .mapToInt(Integer::parseInt)
                .filter(integer -> integer % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        String.format("Can't get min value from list: %s", numbers)));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(value -> value % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> predicateForMenDependedOnAge = person -> person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
        return peopleList.stream()
                .filter(predicateForMenDependedOnAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicateDependedOnSex = person -> person.getAge() >= fromAge
                && (person.getSex() == Person.Sex.MAN
                ? person.getAge() <= maleToAge : person.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(predicateDependedOnSex)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> customPredicate = person -> person.getAge() >= femaleAge
                && person.getSex() == Person.Sex.WOMAN;
        return peopleList.stream()
                .filter(customPredicate)
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
