package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String NUMBERS_DIVIDER = "[,]";
    private final CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        Supplier<RuntimeException> exceptionSupplier = () ->
                new RuntimeException("Can't get min value from list: " + numbers);
        return numbers.stream()
                .map(string -> string.split(NUMBERS_DIVIDER))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(this::isEven)
                .min()
                .orElseThrow(exceptionSupplier);
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(number -> (!isEven(number)) ? numbers.get(number) - 1 : numbers.get(number))
                .filter(number -> number % 2 == 1)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> predicate = person ->
                person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
        return peopleList.stream()
                .filter(predicate)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicate = person ->
                (person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge)
                || (person.getSex() == Person.Sex.WOMAN && person.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge)
                .filter(predicate)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
