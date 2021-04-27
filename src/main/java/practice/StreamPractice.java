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
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(number -> Arrays.stream(number.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(()
                        -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(number -> number % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        Predicate<People> peoplePredicate = people -> people.getAge() >= fromAge
                && people.getAge() <= toAge
                && people.getSex() == People.Sex.MAN;

        return peopleList.stream()
                .filter(peoplePredicate)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        Predicate<People> peoplePredicate = people -> people.getAge() >= fromAge
                && (people.getSex() == People.Sex.MAN
                ? people.getAge() <= maleToAge
                : people.getAge() <= femaleToAge);

        return peopleList.stream()
                .filter(peoplePredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(people -> people.getSex() == People.Sex.WOMEN
                        && people.getAge() >= femaleAge)
                .flatMap(people -> people.getCats().stream())
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
