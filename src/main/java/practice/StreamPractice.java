package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.People;

public class StreamPractice {
    private static final String SPLIT_REGEX = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(n -> Arrays.stream(n.split(SPLIT_REGEX)))
                .map(Integer::parseInt)
                .filter(integer -> integer % 2 == 0)
                .min(Integer::compare)
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: method_input_list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> (i % 2 == 1) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 == 1)
                .average()
                .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(people -> people.getSex() == People.Sex.MAN && people.getAge() >= fromAge
                        && people.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        return peopleList.stream()
                .filter(people -> people.getSex() == People.Sex.MAN
                        ? people.getAge() <= maleToAge && people.getAge() >= fromAge
                        : people.getAge() <= femaleToAge && people.getAge() >= fromAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList.stream().filter(people -> people.getSex() == People.Sex.WOMEN)
                 .filter(people -> people.getAge() >= femaleAge)
                 .map(people -> people.getCats())
                 .flatMap(cats -> cats.stream())
                .map(cat -> cat.getName())
                .collect(Collectors.toList());
    }

    public static List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidate -> new CandidateValidator().test(candidate))
                .map(candidate -> candidate.getName())
                .sorted()
                .collect(Collectors.toList());
    }
}
