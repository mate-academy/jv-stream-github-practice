package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;
import model.Person.Sex;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
            .flatMap(str -> Arrays.stream(str.split(",")))
            .mapToInt(Integer::parseInt)
            .filter(n -> n % 2 == 0)
            .min()
            .orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
            .mapToDouble(n -> n % 2 != 0 ? numbers.get(n) - 1 : numbers.get(n))
            .filter(n -> n % 2 != 0)
            .average()
            .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
            .filter(n -> n.getSex().equals(Sex.MAN) && n.getAge() >= fromAge && n.getAge() <= toAge)
            .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
            .filter(n -> (n.getSex().equals(Sex.WOMAN)
                && n.getAge() >= fromAge && n.getAge() <= femaleToAge)
                || (n.getSex().equals(Sex.MAN)
                && n.getAge() >= fromAge && n.getAge() <= maleToAge))
            .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
            .filter(n -> n.getSex().equals(Sex.WOMAN)
                && n.getAge() >= femaleAge && !n.getCats().isEmpty())
            .flatMap(person -> person.getCats().stream())
            .map(Cat::getName)
            .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator validator = new CandidateValidator();
        return candidates.stream()
            .filter(validator)
            .map(Candidate::getName)
            .sorted()
            .collect(Collectors.toList());

    }
}
