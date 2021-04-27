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
    private static final String MESSAGE_FOR_EXCEPTION = "Can't get min value from list";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers
                .stream()
                .flatMap(number -> Arrays.stream(number.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min().orElseThrow(() -> new RuntimeException(MESSAGE_FOR_EXCEPTION));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
               .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
               .filter(number -> number % 2 != 0)
               .average()
               .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        Predicate<People> checkMenByAge = man ->
                man.getAge() >= fromAge
                && man.getAge() <= toAge
                && man.getSex() == People.Sex.MAN;
        return peopleList
                .stream()
                .filter(checkMenByAge)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        Predicate<People> checkWorkablePeople = people ->
                (people.getSex() == People.Sex.MAN
                        && people.getAge() >= fromAge
                        && people.getAge() <= maleToAge)
                        || (people.getSex() == People.Sex.WOMEN
                        && people.getAge() >= fromAge && people.getAge() <= femaleToAge);
        return peopleList
                .stream()
                .filter(checkWorkablePeople)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList
                .stream()
                .filter(people ->
                        people.getSex() == People.Sex.WOMEN
                        && people.getAge() >= femaleAge)
                .flatMap(catNames -> catNames.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public static List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates
                .stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
