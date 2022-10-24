package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;
import practice.custompredicates.CatOwnersPredicate;
import practice.custompredicates.MenBetweenAgePredicate;
import practice.custompredicates.WorkablePeoplePredicate;

public class StreamPractice {
    public static final String COMA_SEPARATOR = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(e -> e.split(COMA_SEPARATOR))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(i -> (i & 1) == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Stream.iterate(1, i -> i < numbers.size(), i -> i + 2)
                .forEach(i -> copyNumbers.set(i, numbers.get(i) - 1));
        return copyNumbers.stream()
                .filter(n -> (n & 1) == 1)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(new MenBetweenAgePredicate(fromAge, toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(new WorkablePeoplePredicate(fromAge, femaleToAge, maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(new CatOwnersPredicate(femaleAge))
                .flatMap(p -> p.getCats().stream())
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
