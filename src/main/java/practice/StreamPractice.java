package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {
    private static final String EXCEPTION_MESSAGE = "Can't get min value from list: ";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        IntUnaryOperator oddSubtraction = (i) -> i % 2 != 0
                ? (Integer) numbers.toArray()[i] - 1 : (Integer) numbers.toArray()[i];
        return Stream.of(IntStream.range(0, numbers.size())
                .map(oddSubtraction))
                .flatMapToInt(n -> n)
                .filter(n -> n % 2 != 0)
                .average().getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        Predicate<People> peoplePredicate = (people) -> people.getSex() == People.Sex.MAN
                && people.getAge() >= fromAge
                && people.getAge() <= toAge;
        return peopleList.stream()
                .filter(peoplePredicate)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        Predicate<People> peoplePredicate = (people) -> people.getAge() >= fromAge
                && ((people.getSex() == People.Sex.MAN && people.getAge() <= maleToAge)
                || (people.getSex() == People.Sex.WOMEN && people.getAge() <= femaleToAge));
        return peopleList.stream()
                .filter(peoplePredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == People.Sex.WOMEN && p.getAge() >= femaleAge)
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
