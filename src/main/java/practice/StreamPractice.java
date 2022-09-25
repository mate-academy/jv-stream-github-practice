package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        if (numbers != null && numbers.size() > 0) {
            return numbers
                    .stream()
                    .flatMap(l -> Arrays.stream(l.split(",")))
                    .mapToInt(Integer::valueOf)
                    .filter(i -> i % 2 == 0)
                    .min().orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                            + numbers));
        }
        throw new RuntimeException("Can't get min value from list: " + numbers);
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        if (numbers != null && numbers.size() > 0) {
            return IntStream.range(0, numbers.size())
                    .mapToObj(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                    .mapToInt(e -> e)
                    .filter(i -> i % 2 != 0)
                    .average()
                    .orElseThrow(NoSuchElementException::new);
        }
        throw new RuntimeException("Can't get average value from list: " + numbers);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        if (peopleList != null && peopleList.size() > 0) {
            return peopleList
                    .stream()
                    .filter(p -> p.getSex().equals(Person.Sex.MAN)
                            && p.getAge() >= fromAge && p.getAge() <= toAge)
                    .collect(Collectors.toList());
        }
        throw new RuntimeException("List " + peopleList + " is null or empty.");
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        if (peopleList != null && peopleList.size() > 0) {
            return peopleList
                    .stream()
                    .filter(p -> p.getAge() >= fromAge
                            && ((p.getSex().equals(Person.Sex.MAN) && p.getAge() <= maleToAge)
                            || (p.getSex().equals(Person.Sex.WOMAN) && p.getAge() <= femaleToAge)))
                    .collect(Collectors.toList());
        }
        throw new RuntimeException("List " + peopleList + " is null or empty.");
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        if (peopleList != null && peopleList.size() > 0) {
            return peopleList
                    .stream()
                    .filter(p -> p.getSex().equals(Person.Sex.WOMAN)
                            && p.getAge() >= femaleAge && p.getCats().size() > 0)
                    .flatMap(l -> l.getCats().stream())
                    .map(Cat::getName)
                    .collect(Collectors.toList());
        }
        throw new RuntimeException("List " + peopleList + " is null or empty.");
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        if (candidates != null && candidates.size() > 0) {
            Predicate<Candidate> isCandidateValid = new CandidateValidator();
            return candidates
                    .stream()
                    .filter(isCandidateValid)
                    .map(Candidate::getName)
                    .sorted()
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
