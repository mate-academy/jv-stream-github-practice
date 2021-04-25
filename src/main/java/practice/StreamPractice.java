package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(n -> Arrays.stream(n.split(","))
                        .map(Integer::parseInt)
                        .filter(number -> number % 2 == 0)
                        .min(Integer::compare))
                .flatMap(Optional::stream)
                .min(Integer::compare).orElseThrow(()
                        -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        double average = numbers.stream()
                .mapToDouble(n -> numbers.indexOf(n) % 2 != 0 ? n - 1 : n)
                .filter(n -> n % 2 != 0)
                .average()
                .getAsDouble();
        return (double) Math.round(average);
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge && p.getAge() <= toAge)
                .filter(p -> p.getSex().equals(People.Sex.MAN))
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getSex().equals(People.Sex.MAN)
                        ? p.getAge() >= fromAge && p.getAge() <= maleToAge
                        : p.getAge() >= fromAge && p.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= femaleAge
                        && p.getSex().equals(People.Sex.WOMEN))
                .map(People::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public static List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(CandidateValidator::checkCandidate)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
