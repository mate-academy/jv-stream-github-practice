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

    public static List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Stream.of(string.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .mapToDouble(element -> element)
                .filter(number -> number % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        Predicate<People> menSuitForArmyPredicate = person -> person.getAge() >= fromAge
                && person.getAge() <= toAge && person.getSex() == People.Sex.MAN;
        return peopleList.stream()
                .filter(menSuitForArmyPredicate)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        Predicate<People> workablePeoplePredicate = person -> person.getAge() >= fromAge
                && (person.getSex() == People.Sex.MAN ? person.getAge() <= maleToAge
                : person.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(workablePeoplePredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        Predicate<People> womenWithCatsPredicate = person -> person.getSex() == People.Sex.WOMEN
                && person.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(womenWithCatsPredicate)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }
}
