package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.People;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(","))
                .flatMap(strings -> Arrays.stream(strings))
                .map(Integer::parseInt)
                .filter(integer -> integer % 2 == 0)
                .sorted()
                .findFirst()
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
                .filter(people -> people.getSex() == People.Sex.MAN)
                .filter(people -> people.getAge() >= fromAge && people.getAge() <= toAge)
                .collect(Collectors.toList());

    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        return peopleList.stream()
                .filter(people -> people.getAge() >= fromAge)
                .filter(people -> people.getSex() == People.Sex.MAN
                        ? people.getAge() <= maleToAge :
                        people.getAge() <= femaleToAge).collect(Collectors.toList());
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
        return candidates.stream().filter(candidate -> new CandidateValidator().test(candidate))
                .map(candidate -> candidate.getName())
                .sorted()
                .collect(Collectors.toList());
    }
}
