package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(p -> Arrays.stream(p.split(",")))
                .map(Integer::valueOf)
                .mapToInt(i -> i)
                .filter(i -> i % 2 == 0)
                .min().orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: < Here is our input 'numbers' >"
                ));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        AtomicInteger counter = new AtomicInteger();
        return numbers.stream()
                .mapToInt(i -> i)
                .map(n -> {
                    if (counter.getAndIncrement() % 2 == 1) {
                        return n - 1;
                    }
                    return n;
                })
                .filter(i -> i % 2 == 1)
                .average().orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN)
                .filter(i -> i.getAge() >= fromAge && i.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> (p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge && p.getAge() <= maleToAge)
                        || (p.getSex() == Person.Sex.WOMAN
                        && p.getAge() >= fromAge && p.getAge() <= femaleToAge)
                )
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> (p.getSex() == Person.Sex.WOMAN) && p.getAge() >= femaleAge)
                .flatMap(w -> w.getCats().stream())
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
