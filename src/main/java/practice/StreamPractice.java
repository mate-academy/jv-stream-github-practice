package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {
    private static final double EPSILON = 0.000001d;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(n -> Arrays.stream(n.split(",")))
                .map(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min(Integer::compare)
                .orElseThrow(()
                        -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(i -> Math.abs(i % 2) > EPSILON ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> Math.abs(n % 2) > EPSILON)
                .average()
                .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge
                        && p.getAge() <= toAge
                        && p.getSex() == People.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getSex() == People.Sex.MAN
                        ? p.getAge() >= fromAge && p.getAge() <= maleToAge
                        : p.getAge() >= fromAge && p.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= femaleAge
                        && p.getSex() == People.Sex.WOMEN)
                .flatMap(c -> c.getCats().stream())
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
