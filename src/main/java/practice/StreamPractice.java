package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {

    private static final String DELIMITER = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(DELIMITER)))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: "
                                + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        Predicate<People> peoplePredicate = p -> p.getAge() >= fromAge
                && p.getAge() <= toAge
                && p.getSex().equals(People.Sex.MAN);
        return peopleList.stream()
                .filter(peoplePredicate)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        Predicate<People> predicatePerson = p -> p.getAge() >= fromAge
                && (p.getSex().equals(People.Sex.MAN) ? p.getAge() <= maleToAge
                : p.getAge() <= femaleToAge);
        return peopleList.stream()
                 .filter(predicatePerson)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        Predicate<People> peoplePredicate = owner -> owner.getSex().equals(People.Sex.WOMEN)
                && owner.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(peoplePredicate)
                .flatMap(owner -> owner.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public static List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
