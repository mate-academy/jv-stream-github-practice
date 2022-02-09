package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;
import model.Person.Sex;

public class StreamPractice {
    private static final String SPLIT_SEPARATOR = ",";

    public int findMinEvenNumber(List<String> numbers) {
        Predicate<Integer> selectEvenNumberPredicat = e -> e % 2 == 0;
        return numbers.stream()
            .flatMap(e -> Arrays.stream(e.split(SPLIT_SEPARATOR)))
            .map(Integer::parseInt)
            .filter(selectEvenNumberPredicat)
            .min(Integer::compareTo)
            .orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        IntPredicate selectOddNumberPredicat = e -> e % 2 == 1;
        return IntStream.range(0, numbers.size())
            .map(e -> e % 2 == 1 ? numbers.get(e) - 1 : numbers.get(e))
            .filter(selectOddNumberPredicat)
            .average()
            .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> selectMenByAgePredicat = e -> e.getSex() == Sex.MAN
                && e.getAge() > fromAge
                && e.getAge() <= toAge;
        return peopleList.stream()
            .filter(selectMenByAgePredicat)
            .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> selectPersonByAgePredicat =
                e -> (e.getSex() == Sex.MAN && (e.getAge() >= fromAge
                    && e.getAge() <= maleToAge))
                || (e.getSex() == Sex.WOMAN && (e.getAge() >= fromAge
                    && e.getAge() <= femaleToAge));
        return peopleList.stream()
            .filter(selectPersonByAgePredicat)
            .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> selectWomenFromAgePredicat =
                e -> e.getSex() == Sex.WOMAN && e.getAge() >= femaleAge;
        return peopleList.stream()
            .filter(selectWomenFromAgePredicat)
            .flatMap(e -> e.getCats().stream())
            .map(Cat::getName)
            .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
            .filter(new CandidateValidator())
            .map(Candidate::getName)
            .sorted()
            .collect(Collectors.toList());
    }
}
