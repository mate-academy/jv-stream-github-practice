package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String SEPARATOR = ",";

    public int findMinEvenNumber(List<String> numbers) {
        List<Integer> evenNumbers = numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(SEPARATOR)))
                .map(Integer::valueOf)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        return numbers.stream()
                .flatMap(s -> Stream.of(s.split(SEPARATOR)))
                .map(Integer::valueOf)
                .filter(num -> num % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Can't get min "
                        + "value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> modifiedNumbers = IntStream.range(0, numbers.size())
                .mapToObj(i -> (i % 2 == 1) ? numbers.get(i) - 1 : numbers.get(i))
                .collect(Collectors.toList());

        List<Integer> oddNumbers = modifiedNumbers.stream()
                .filter(num -> num % 2 == 1)
                .collect(Collectors.toList());

        return oddNumbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<? super Person> workablePredicate = person -> person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge && person.getAge() <= maleToAge
                || person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= fromAge && person.getAge() <= femaleToAge;
        return peopleList.stream()
                .filter(workablePredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();

        return candidates.stream()
                .filter(candidate -> candidateValidator.test(candidate))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
