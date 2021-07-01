package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        List<Integer> list = numbers.stream().flatMap(string -> Arrays.stream(string.split(",")))
                .map(Integer::parseInt)
                .filter((p) -> p % 2 == 0)
                .collect(Collectors.toList());
        if (list.equals(Collections.EMPTY_LIST)) {
            throw new RuntimeException("Can't get min value from list: <>");
        }
        return list.stream().mapToInt((n) -> n).min().getAsInt();
    }

    public Double getOddNumsAverage(List<Integer

            > numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble((i) -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter((n) -> n % 2 == 1)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter((p) -> fromAge <= p.getAge()
                        && p.getAge() <= toAge && p.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream().filter((p) -> {
            if (p.getSex() == Person.Sex.MAN) {
                return fromAge <= p.getAge() && p.getAge() <= maleToAge;
            }
            return fromAge <= p.getAge() && p.getAge() <= femaleToAge;
        }).collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream().filter((p) -> {
            return p.getSex() == Person.Sex.WOMAN
                    && p.getAge() >= femaleAge;
        }).map((p) -> p.getCats())
                .flatMap((p) -> p.stream().map((Cat::getName)))
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
