package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        if (numbers.isEmpty()) {
            throw new RuntimeException("Can't get min value from list");
        }
        return numbers.stream()
                .map(n -> n.split(","))
                .flatMap(l -> Arrays.stream(l))
                .map(s -> Integer.parseInt(s))
                .filter(i -> i % 2 == 0)
                .min(Integer::compare)
                .get();
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(integer -> integer % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> (p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge && p.getAge() <= maleToAge)
                        || (p.getSex() == Person.Sex.WOMAN
                        && p.getAge() >= fromAge && p.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN && p.getAge() >= femaleAge)
                .map(p -> p.getCats())
                .flatMap(l -> l.stream())
                .map(c -> c.getName())
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(c -> new CandidateValidator().test(c))
                .map(c -> c.getName())
                .sorted()
                .collect(Collectors.toList());
    }
}
