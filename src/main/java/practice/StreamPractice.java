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
    private static final String NO_MIN_VALUE_EXCEPTION_MESSAGE = "Can't get min value from list: ";
    private static final String EMPTY_LIST_EXCEPTION_MESSAGE = "Empty List provided";
    private static final String SPLIT_REGEX_COMA = ",";
    private final Predicate<Candidate> isAbleToRunForPresident = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
            .map(stringNumber -> stringNumber.split(SPLIT_REGEX_COMA))
            .flatMap(Arrays::stream)
            .map(Integer::parseInt)
            .filter(number -> number % 2 == 0)
            .sorted()
            .findFirst()
            .orElseThrow(() -> new RuntimeException(NO_MIN_VALUE_EXCEPTION_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
            .map(index -> {
                Integer numByIndex = numbers.get(index);
                return index % 2 != 0 ? numByIndex - 1 : numByIndex;
            })
            .filter(number -> number % 2 != 0)
            .average()
            .orElseThrow(() -> new NoSuchElementException(EMPTY_LIST_EXCEPTION_MESSAGE));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
            .filter(person -> {
                int personAge = person.getAge();
                ;
                return personAge >= fromAge
                    && personAge <= toAge
                    && person.getSex().equals(Sex.MAN);
            })
            .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
            int maleToAge, List<Person> peopleList) {
        Predicate<Person> isWorkable = person -> {
            int personAge = person.getAge();
            if (person.getSex().equals(Sex.MAN)) {
                return personAge >= fromAge
                    && personAge <= maleToAge;
            }
            return personAge >= fromAge
                && personAge <= femaleToAge;
        };
        return peopleList.stream()
            .filter(isWorkable)
            .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> isNeededCatOwner = person -> person.getSex().equals(Sex.WOMAN)
                && person.getAge() >= femaleAge;
        return peopleList.stream()
            .filter(isNeededCatOwner)
            .flatMap(person -> person.getCats().stream())
            .map(Cat::getName)
            .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
            .filter(isAbleToRunForPresident)
            .map(Candidate::getName)
            .sorted()
            .toList();
    }
}
