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
    private static final String NO_VALUE_FOUND_EXCEPTION = "Can't get min value from list: ";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(stringOfNumbers -> Arrays.stream(stringOfNumbers.split(",")))
                .mapToInt(Integer::valueOf)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException(NO_VALUE_FOUND_EXCEPTION + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 == 0 ? numbers.get(index) : numbers.get(index) - 1)
                .filter(number -> number % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        Predicate<People> menWithinAgeRange =
                person -> person.getSex() == People.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
        return peopleList.stream()
                .filter(menWithinAgeRange)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        Predicate<People> personWithinAgeRange =
                person -> person.getAge() >= fromAge
                        && (person.getSex() == People.Sex.MAN
                        ? person.getAge() <= maleToAge
                        : person.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(personWithinAgeRange)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        Predicate<People> womenByAge =
                person -> person.getSex() == People.Sex.WOMEN && person.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(womenByAge)
                .flatMap(woman -> woman.getCats().stream())
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
