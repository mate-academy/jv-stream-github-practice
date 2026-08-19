package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        if (numbers == null) {
            throw new RuntimeException("Can't get min value from list: " + numbers);
        }

        return numbers.stream()
                .filter(Objects::nonNull)
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        if (numbers == null) {
            throw new NoSuchElementException();
        }

        OptionalDouble avg = IntStream.range(0, numbers.size())
                .mapToObj(i -> {
                    Integer val = numbers.get(i);
                    if (val == null) {
                        return null; // буде відфільтровано нижче
                    }
                    if (i % 2 == 1) {
                        return val - 1;
                    }
                    return val;
                })
                .filter(Objects::nonNull) // важливо: фільтруємо null до unboxing
                .mapToInt(Integer::intValue)
                .filter(n -> Math.abs(n % 2) == 1)
                .average();

        if (avg.isPresent()) {
            return avg.getAsDouble();
        } else {
            throw new NoSuchElementException();
        }
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        if (peopleList == null) {
            return Collections.emptyList();
        }

        return peopleList.stream()
                .filter(Objects::nonNull)
                .filter(p -> Person.Sex.MAN.equals(p.getSex()))
                .filter(p -> p.getAge() >= fromAge && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        if (peopleList == null) {
            return Collections.emptyList();
        }

        return peopleList.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getAge() >= fromAge)
                .filter(p -> {
                    if (Person.Sex.MAN.equals(p.getSex())) {
                        return p.getAge() <= maleToAge;
                    } else {
                        return p.getAge() <= femaleToAge;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        if (peopleList == null) {
            return Collections.emptyList();
        }

        return peopleList.stream()
                .filter(Objects::nonNull)
                .filter(p -> Person.Sex.WOMAN.equals(p.getSex()))
                .filter(p -> p.getAge() >= femaleAge)
                .flatMap(p -> {
                    List<Cat> cats = p.getCats();
                    return cats == null ? java.util.stream.Stream.empty() : cats.stream();
                })
                .filter(Objects::nonNull)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        if (candidates == null) {
            return Collections.emptyList();
        }

        CandidateValidator validator = new CandidateValidator();

        return candidates.stream()
                .filter(Objects::nonNull)
                .filter(validator)
                .map(Candidate::getName)
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());
    }
}
