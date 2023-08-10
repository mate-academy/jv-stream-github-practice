package practice;

import filter.GetWorkablePeopleFilter;
import filter.SelectMenByAgeFilter;
import filter.SelectWomanByAgeFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::valueOf)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(integer -> isOdd(integer) ? numbers.get(integer) - 1 : numbers.get(integer))
                .filter(StreamPractice::isOdd)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> new SelectMenByAgeFilter().test(
                        Map.of("fromAge", fromAge,
                                "toAge", toAge,
                                "person", person)))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> new GetWorkablePeopleFilter().test(
                        Map.of("fromAge", fromAge,
                        "femaleToAge", femaleToAge,
                        "maleToAge", maleToAge,
                        "person", person)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> new SelectWomanByAgeFilter().test(
                        Map.of("femaleAge", femaleAge,
                                "person", person)))
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

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
