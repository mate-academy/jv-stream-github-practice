package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(number -> number % 2 != 0)
                .mapToDouble(Double::valueOf)
                .average()
                .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(human -> human.getSex().equals(People.Sex.MAN)
                        && human.getAge() >= fromAge
                        && human.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        return peopleList.stream()
                .filter(human -> (human.getSex().equals(People.Sex.MAN)
                        && human.getAge() >= fromAge
                        && human.getAge() <= maleToAge)
                        || (human.getSex().equals(People.Sex.WOMEN)
                        && human.getAge() >= fromAge
                        && human.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        List<People> validPeople = peopleList.stream()
                .filter(human -> human.getSex().equals(People.Sex.WOMEN)
                        && human.getAge() >= femaleAge)
                .collect(Collectors.toList());
        return validPeople.stream()
                .map(People::getCats)
                .flatMap(Collection::stream)
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
