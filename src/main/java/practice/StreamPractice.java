package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    private static final String SPLIT = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(SPLIT)))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(integer -> integer % 2 == 1)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && (fromAge <= person.getAge() && person.getAge() <= toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN
                        && (p.getAge() >= fromAge && p.getAge() <= femaleToAge)
                        || p.getSex() == Person.Sex.MAN
                        && (p.getAge() >= fromAge && p.getAge() <= maleToAge))
                .collect(Collectors.toList());
    }

    public static List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .flatMap(c -> c.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public static List<String> validateCandidates(List<Candidate> candidates) {
        Predicate<Candidate> validate = new CandidateValidator();
        return candidates.stream()
                .filter(validate)
                .sorted(Comparator.comparing(Candidate::getName))
                .map(Candidate::getName)
                .collect(Collectors.toList());
    }
}
