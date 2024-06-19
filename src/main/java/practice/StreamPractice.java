package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;
import model.Person.Sex;

public class StreamPractice {

    private static final String COMMA = ",";

    public int findMinEvenNumber(List<String> numb) {
        return numb.stream()
                .flatMapToInt(s -> Arrays.stream(s.split(COMMA)).mapToInt(Integer::parseInt))
                .filter(num -> num % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: " + numb));
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
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge, List<Person> peopleList) {
        Predicate<Person> workablePredicate = p ->
                (p.getSex() == Sex.WOMAN && p.getAge()
                        >= fromAge && p.getAge() <= femaleToAge)
                        || (p.getSex() == Sex.MAN && p.getAge() >= fromAge && p.getAge() <= maleToAge);

        return peopleList.stream()
                .filter(workablePredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Sex.WOMAN && p.getAge() >= femaleAge)
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
