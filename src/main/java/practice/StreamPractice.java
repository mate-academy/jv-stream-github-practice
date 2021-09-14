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
    private static final String RUNTIME_MESSAGE = "Can't get min value from list:";
    private static final String SPLIT_REGEX = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(numberArray -> numberArray.split(SPLIT_REGEX))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(RUNTIME_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 == 1 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(number -> number % 2 == 1)
                .average().orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> personPredicate = person -> person.getAge() >= fromAge
                && person.getAge() <= toAge && person.getSex() == Person.Sex.MAN;
        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = person -> (person.getAge() >= fromAge && person.getAge() <= maleToAge
                && person.getSex() == Person.Sex.MAN)
                || (person.getAge() >= fromAge && person.getAge() <= femaleToAge
                && person.getSex() == Person.Sex.WOMAN);
        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN && person.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
