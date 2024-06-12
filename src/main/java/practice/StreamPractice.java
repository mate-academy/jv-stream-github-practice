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
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .map(Integer::valueOf)
                .filter(n -> n % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> adjustedNumbers = IntStream.range(0, numbers.size())
                .mapToObj(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .toList();

        return adjustedNumbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException(
                        "No odd numbers found in the provided list after adjustment: " + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .filter(p -> p.getAge() >= fromAge)
                .filter(p -> p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge,
                                          List<Person> peopleList) {
        WorkablePersonPredicate predicate = new WorkablePersonPredicate(
                fromAge, femaleToAge, maleToAge);
        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Sex.WOMAN)
                .filter(p -> p.getAge() >= femaleAge)
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
