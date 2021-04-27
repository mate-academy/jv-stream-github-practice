package practice;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Stream.of(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min "
                        + "value from list:" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                    .map(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                    .filter(n -> n % 2 == 1)
                    .average()
                    .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        Predicate<People> peoplePredicate = p -> p.getSex().equals(People.Sex.MAN)
                && p.getAge() >= fromAge && p.getAge() <= toAge;
        return peopleList.stream()
                .filter(peoplePredicate)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge,
                                          List<People> peopleList) {
        Predicate<People> peoplePredicate = p -> p.getSex().equals(People.Sex.MAN)
                && p.getAge() >= fromAge
                && p.getAge() <= maleToAge
                || p.getSex().equals(People.Sex.WOMEN)
                && p.getAge() >= fromAge
                && p.getAge() <= femaleToAge;

        return peopleList.stream()
                .filter(peoplePredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        Predicate<People> peoplePredicate = p -> p.getSex().equals(People.Sex.WOMEN)
                && p.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(peoplePredicate)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public static List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
