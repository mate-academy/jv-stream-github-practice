package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String COMMA = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers
                .stream()
                .map(x -> x.split(COMMA))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: "
                                + "method_input_list"
                ));

    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(x -> x % 2 != 0
                        ? numbers.get(x) - 1
                        : numbers.get(x))
                .filter(x -> x % 2 != 0)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(x -> x.getSex().equals(Person.Sex.MAN)
                        && x.getAge() >= fromAge
                        && x.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(x -> (x.getSex().equals(Person.Sex.MAN)
                        && x.getAge() >= fromAge
                        && x.getAge() <= maleToAge)
                        || (x.getSex() == Person.Sex.WOMAN
                        && x.getAge() >= fromAge
                        && x.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(x -> x.getSex().equals(Person.Sex.WOMAN)
                        && x.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(x -> new CandidateValidator().test(x))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
