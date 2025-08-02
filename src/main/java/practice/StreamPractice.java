package practice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;
import model.Person.Sex;

public class StreamPractice {
    private static final String COMMA_DELIMITER = ",";
    private static final int EVEN_DIVISOR = 2;
    private static final int ODD_DIVISOR = 2;
    private static final int ODD_SUBTRACTOR = 1;
    private static final int EVEN_REMAINDER = 0;
    private static final int ODD_REMAINDER = 1;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> List.of(s.split(COMMA_DELIMITER)).stream())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(n -> n % EVEN_DIVISOR == EVEN_REMAINDER)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> modified = IntStream.range(0, numbers.size())
                .map(i -> i % ODD_DIVISOR != EVEN_REMAINDER
                        ? numbers.get(i) - ODD_SUBTRACTOR : numbers.get(i))
                .boxed()
                .collect(Collectors.toList());

        return modified.stream()
                .filter(n -> n % ODD_DIVISOR != EVEN_REMAINDER)
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .filter(p -> p.getAge() >= fromAge && p.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge)
                .filter(p -> (p.getSex() == Sex.MAN && p.getAge() <= maleToAge)
                        || (p.getSex() == Sex.WOMAN && p.getAge() <= femaleToAge))
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
        CandidateValidator validator = new CandidateValidator();
        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
