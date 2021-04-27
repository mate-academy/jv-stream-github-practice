package practice;

import java.util.Arrays;
import java.util.Collection;
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
                .flatMap(numbersString -> Arrays.stream(numbersString.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
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
        Predicate<People> peoplePredicateMaleAge = people ->
                people.getSex() == People.Sex.MAN
                && people.getAge() >= fromAge && people.getAge() <= toAge;
        return peopleList.stream()
                .filter(peoplePredicateMaleAge)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        Predicate<People> peoplePredicateAgeGender = people ->
                people.getSex() == People.Sex.MAN
                && people.getAge() >= fromAge && people.getAge() <= maleToAge
                || people.getSex() == People.Sex.WOMEN
                && people.getAge() >= fromAge && people.getAge() <= femaleToAge;
        return peopleList.stream()
                .filter(peoplePredicateAgeGender)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        Predicate<People> peoplePredicateFemaleAge = people ->
                people.getSex() == People.Sex.WOMEN
                && people.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(peoplePredicateFemaleAge)
                .map(People::getCats)
                .flatMap(Collection::stream)
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
