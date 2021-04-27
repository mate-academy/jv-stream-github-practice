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
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(number -> (number & 1) == 0)
                .min().orElseThrow(() ->
                        new RuntimeException("Can't get min value from list:"
                                + numbers.toString()));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> (index & 1) == 1 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(number -> (number & 1) == 1)
                .average()
                .orElseThrow();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {

        Predicate<People> filterByAgeAndSex = person -> person.getSex() == People.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;

        return peopleList.stream()
                .filter(filterByAgeAndSex)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {

        Predicate<People> filterWorkable = person -> person.getAge() >= fromAge
                && ((person.getAge() <= maleToAge && person.getSex() == People.Sex.MAN)
                || (person.getAge() <= femaleToAge && person.getSex() == People.Sex.WOMEN));

        return peopleList.stream()
                .filter(filterWorkable)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {

        return peopleList.stream()
                .filter(person -> person.getSex() == People.Sex.WOMEN
                        && person.getAge() >= femaleAge)
                .flatMap(people -> people.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public static List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator getValidCandidate = new CandidateValidator();
        return candidates.stream()
                .filter(getValidCandidate)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
