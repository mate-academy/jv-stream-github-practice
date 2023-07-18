package practice;

import filter.GetWorkablePeopleFilter;
import filter.SelectMenByAgeFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public static final GetWorkablePeopleFilter getWorkablePeopleFilter =
            new GetWorkablePeopleFilter();
    public static final SelectMenByAgeFilter selectMenByAgeFilter =
            new SelectMenByAgeFilter();
    private static final CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::valueOf)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> collect = IntStream.range(0, numbers.size())
                .filter(i -> i % 2 != 0)
                .map(i -> numbers.set(i, numbers.get(i) - 1))
                .boxed()
                .collect(Collectors.toList());
        return numbers.stream()
                .filter(i -> i % 2 != 0)
                .mapToDouble(s -> s)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> selectMenByAgeFilter.test(
                        Map.of("fromAge", fromAge,
                                "toAge", toAge,
                                "person", person)))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> getWorkablePeopleFilter.test(
                        Map.of("fromAge", fromAge,
                        "femaleToAge", femaleToAge,
                        "maleToAge", maleToAge,
                        "person", person)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.WOMAN)
                        && p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
