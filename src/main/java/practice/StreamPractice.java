package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import model.Candidate;
import model.Cat;
import model.Person;
import model.Person.Sex;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        String msgPrefix = "Can't get min value from list: ";
        String msg = msgPrefix + numbers;

        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(msg));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return java.util.stream.IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> people, int fromAge, int toAge) {
        return people.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .filter(p -> p.getAge() >= fromAge && p.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(
            int fromAge,
            int femaleToAge,
            int maleToAge,
            List<Person> people
    ) {
        return people.stream()
                .filter(p -> p.getAge() >= fromAge)
                .filter(p -> (p.getSex() == Sex.MAN && p.getAge() <= maleToAge)
                        || (p.getSex() == Sex.WOMAN && p.getAge() <= femaleToAge))
                .toList();
    }

    public List<String> getCatsNames(List<Person> people, int femaleAge) {
        return people.stream()
                .filter(p -> p.getSex() == Sex.WOMAN && p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
