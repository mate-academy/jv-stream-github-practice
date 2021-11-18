package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(e -> Arrays.stream(e.split(",")))
                .mapToInt(Integer::parseInt).filter(s -> s % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(e -> e % 2 != 0 ? numbers.get(e) - 1 : numbers.get(e))
                .filter(e -> e % 2 != 0)
                .average().orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(s -> s.getSex().equals(Person.Sex.MAN)
                        && s.getAge() >= fromAge
                        && s.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream().filter(s -> s.getAge() >= fromAge
                        && (s.getSex().equals(Person.Sex.MAN)
                        && s.getAge() <= maleToAge
                        || s.getSex().equals(Person.Sex.WOMAN)
                        && s.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(e -> e.getSex().equals(Person.Sex.WOMAN) && e.getAge() >= femaleAge)
                .flatMap(e -> e.getCats().stream().map(Cat::getName))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream().filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
