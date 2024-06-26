package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;
import model.Person.Sex;

public class StreamPractice {

    private static final String COMMA = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMapToInt(s -> Arrays.stream(s.split(COMMA)).mapToInt(Integer::parseInt))
                .filter(num -> num % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Sex.MAN && p.getAge() >= fromAge && p.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(
            int fromAge, int femaleToAge, int maleToAge, List<Person> peopleList) {
        Predicate<Person> workablePredicate = p -> {
            int maxAge = (p.getSex() == Sex.WOMAN) ? femaleToAge : maleToAge;
            return p.getAge() >= fromAge && p.getAge() <= maxAge;
        };

        return peopleList.stream()
                .filter(workablePredicate)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
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
