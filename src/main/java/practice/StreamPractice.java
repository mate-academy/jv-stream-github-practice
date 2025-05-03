package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;
import practice.custompredicates.CatOwnersPredicate;
import practice.custompredicates.MenBetweenAgePredicate;
import practice.custompredicates.WorkablePeoplePredicate;

public class StreamPractice {
    private static final String COMA_SEPARATOR = ",";
    private static int iteratorIndex;

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
        iteratorIndex = 0;
        return numbers.stream()
                .map(n -> (iteratorIndex++ & 1) == 1 ? n - 1 : n)
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
