package practice;

import java.util.Arrays;
import java.util.List;
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
                .flatMap(string -> Arrays.stream(string.split(DELIMITER)))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: "
                                + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(index -> index % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        Predicate<People> selectMenPredicate = person -> person.getAge() >= fromAge
                && person.getAge() <= toAge
                && person.getSex().equals(People.Sex.MAN);
        return peopleList.stream()
                .filter(selectMenPredicate)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        Predicate<People> workablePeoplePredicate = person -> person.getAge() >= fromAge
                && (person.getSex().equals(People.Sex.MAN) ? person.getAge() <= maleToAge
                : person.getAge() <= femaleToAge);
        return peopleList.stream()
                 .filter(workablePeoplePredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        Predicate<People> ownerPredicate = owner -> owner.getSex().equals(People.Sex.WOMEN)
                && owner.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(ownerPredicate)
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
