package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String SPLITER = ",";
    private static final int CHECK_EVEN_NUMBER = 2;
    private static final int SUBTRACT_NUMBER = 1;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> Arrays.asList(s.split(SPLITER)))
                .flatMap(Collection::stream)
                .mapToInt(Integer::valueOf)
                .filter(v -> v % CHECK_EVEN_NUMBER == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % CHECK_EVEN_NUMBER == 0 ? numbers.get(i) :
                        numbers.get(i) - SUBTRACT_NUMBER)
                .filter(n -> n % CHECK_EVEN_NUMBER != 0)
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
        Predicate<Person> workablePeopleValidator = p -> p.getAge() >= fromAge
                && (p.getSex() == Person.Sex.MAN && p.getAge() <= maleToAge
                || p.getSex() == Person.Sex.WOMAN && p.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(workablePeopleValidator)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN
                        && p.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(c -> candidateValidator.test(c))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
