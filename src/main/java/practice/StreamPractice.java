package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .mapToInt(n -> n)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> (i % 2 == 0) ? numbers.get(i) : numbers.get(i) - 1)
                .filter(n -> n % 2 == 1)
                .mapToDouble(n -> (double) n)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Don't have the element."));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(m -> m.getAge() >= fromAge && m.getAge() <= toAge
                        && m.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge && ((p.getSex() == Person.Sex.WOMAN
                        && p.getAge() <= femaleToAge)
                        || (p.getAge() <= maleToAge
                        && p.getSex() == Person.Sex.MAN)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(owner -> owner.getAge() >= femaleAge && owner.getSex() == Person.Sex.WOMAN)
                .flatMap(c -> c.getCats().stream())
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
