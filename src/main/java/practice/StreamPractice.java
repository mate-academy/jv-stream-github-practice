package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
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
        Predicate<People> selectMen = new Predicate<People>() {
            @Override
            public boolean test(People human) {
                return human.getSex().equals(People.Sex.MAN)
                        && human.getAge() >= fromAge
                        && human.getAge() <= toAge;
            }
        };
        return peopleList.stream()
                .filter(selectMen)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        Predicate<People> selectPeople = new Predicate<People>() {
            @Override
            public boolean test(People human) {
                return (human.getSex().equals(People.Sex.MAN)
                        && human.getAge() >= fromAge
                        && human.getAge() <= maleToAge)
                        || (human.getSex().equals(People.Sex.WOMEN)
                        && human.getAge() >= fromAge
                        && human.getAge() <= femaleToAge);
            }
        };
        return peopleList.stream()
                .filter(selectPeople)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        Predicate<People> selectPeople = new Predicate<People>() {
            @Override
            public boolean test(People human) {
                return human.getSex().equals(People.Sex.WOMEN)
                        && human.getAge() >= femaleAge;
            }
        };
        return peopleList.stream()
                .filter(selectPeople)
                .flatMap(people -> people.getCats().stream())
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
