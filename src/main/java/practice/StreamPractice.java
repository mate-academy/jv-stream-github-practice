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

public class StreamPractice {
    public static final String NUMBER_SEPARATOR = ",";
    private CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMapToInt(s -> Arrays.stream(s.split(NUMBER_SEPARATOR))
                        .mapToInt(Integer::parseInt))
                .filter(this::isEven)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> !isEven(i) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> !isEven(i))
                .average()
                .orElseThrow(() -> new NoSuchElementException("No odds numbers!"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> isManValid(fromAge, toAge, p))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> isPersonValid(fromAge, femaleToAge, maleToAge, p))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.WOMAN) && p.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    private Predicate<Person> isWomanValid(int femaleAge) {
        return person -> person.getAge() >= femaleAge && person.getSex() == Person.Sex.WOMAN;
    }

    private boolean isManValid(int fromAge, int toAge, Person person) {
        return person.getSex() == Person.Sex.MAN
                && person.getAge() <= toAge && person.getAge() >= fromAge;
    }

    private boolean isPersonValid(int fromAge, int femaleToAge, int maleToAge, Person person) {
        return person.getAge() >= fromAge
                && ((person.getSex().equals(Person.Sex.MAN) && person.getAge() <= maleToAge)
                || (person.getSex().equals(Person.Sex.WOMAN) && person.getAge() <= femaleToAge));
    }
}
