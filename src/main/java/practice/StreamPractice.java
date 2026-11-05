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
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return IntStream.range(0, numbers.size())
                .map(i -> {
                    int num = numbers.get(i);
                    return (i % 2 != 0) ? num - 1 : num;
                })
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        if (peopleList == null || peopleList.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.MAN)
                        && p.getAge() >= fromAge && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> {
                    if (p.getSex().equals(Person.Sex.MAN)) {
                        return p.getAge() >= fromAge && p.getAge() <= maleToAge;
                    } else if (p.getSex().equals(Person.Sex.WOMAN)) {
                        return p.getAge() >= fromAge && p.getAge() <= femaleToAge;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> !p.getCats().isEmpty() && p.getSex().equals(Person.Sex.WOMAN)
                        && p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
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
