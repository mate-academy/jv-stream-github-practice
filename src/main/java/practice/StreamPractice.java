package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        try {
            return numbers.stream()
                    .map(p -> p.split(","))
                    .flatMapToInt(a -> Arrays.stream(a)
                            .mapToInt(Integer::parseInt))
                    .filter(n -> n % 2 == 0)
                    .boxed()
                    .min(Integer::compareTo)
                    .get();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't get min value from list", e);
        }
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.iterate(0, i -> i + 1)
                .limit(numbers.size())
                .map(i -> (i % 2 == 1)
                        ? ((numbers.get(i) - 1) % 2 == 1
                                ? numbers.get(i) - 1
                                : 0)
                        : (numbers.get(i) % 2 == 1)
                                ? numbers.get(i)
                                : 0)
                .filter(i -> i != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> (p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge
                        && p.getAge() <= toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge
                        && ((p.getSex() == Person.Sex.MAN
                                && p.getAge() <= maleToAge)
                        || (p.getSex() == Person.Sex.WOMAN
                                && p.getAge() <= femaleToAge)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN
                        && p.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(p -> new CandidateValidator().test(p))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
