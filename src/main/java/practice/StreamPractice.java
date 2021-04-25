package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {
    private int indexCounter;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::valueOf)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        indexCounter = 0;
        return numbers.stream()
                .mapToDouble(n -> indexCounter++ % 2 == 0 ? (double) n : (double) n - 1)
                .filter(n -> n % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == People.Sex.MAN
                        && p.getAge() >= fromAge
                        && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        return peopleList.stream()
                .filter(personWithinAgeRange(fromAge, femaleToAge, maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == People.Sex.WOMEN && p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream().map(Cat::getName))
                .collect(Collectors.toList());
    }

    public static List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private Predicate<? super People> personWithinAgeRange(int fromAge,
                                                           int femaleToAge, int maleToAge) {
        return person -> person.getSex() == People.Sex.MAN
                ? (person.getAge() >= fromAge && person.getAge() <= maleToAge)
                : (person.getAge() >= fromAge && person.getAge() <= femaleToAge);
    }
}
