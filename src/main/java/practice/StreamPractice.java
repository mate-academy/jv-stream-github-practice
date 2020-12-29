package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers
                .stream()
                .flatMap(x -> Arrays.stream(x.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(s -> s % 2 == 0)
                .min().orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> (i % 2 == 1) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 == 1)
                .average()
                .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        return peopleList
                .stream()
                .filter(people -> people.getAge() >= fromAge && people.getAge() <= toAge
                && people.getSex() == People.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        return peopleList
                .stream()
                .filter(people -> (people.getSex() == People.Sex.MAN
                        && people.getAge() <= maleToAge && people.getAge() >= fromAge)
                || (people.getSex() == People.Sex.WOMEN)
                        && people.getAge() <= femaleToAge && people.getAge() >= fromAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList
                .stream()
                .filter(people -> people.getSex() == People.Sex.WOMEN
                        && people.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public static List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidatePredicate = new CandidateValidator();
        return candidates
                .stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
