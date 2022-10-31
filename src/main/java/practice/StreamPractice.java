package practice;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String COMMA = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> List.of(s.split(COMMA)))
                .flatMap(Collection::stream)
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                .filter(i -> i % 2 != 0)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> predicate = h -> h.getSex() == Person.Sex.MAN
                && h.getAge() > fromAge
                && h.getAge() <= toAge;
        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicate = h -> h.getAge() >= fromAge
                && ((h.getSex() == Person.Sex.MAN && h.getAge() <= maleToAge)
                || (h.getSex() == Person.Sex.WOMAN && h.getAge() <= femaleToAge));
        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> predicate = p -> p.getSex() == Person.Sex.WOMAN
                && p.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(predicate)
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
}
