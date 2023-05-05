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
    private static final int SUBTRACTABLE_NUMBER = 1;
    private static final int HUMAN_MAX_AGE = 100;
    private static final String EXCEPTION_MESSAGE = "Can't get min value from list: ";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min().orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        int[] numbersArray = numbers.stream().mapToInt(n -> n).toArray();
        IntStream.range(0, numbers.size())
                .filter(n -> n % 2 != 0)
                .peek(i -> numbersArray[i] -= SUBTRACTABLE_NUMBER)
                .toArray();

        return Arrays.stream(numbersArray)
                .filter(n -> n % 2 != 0)
                .average().orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return selectPersonByAgeAndSex(peopleList, fromAge, toAge, Person.Sex.MAN);
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personChecker = p -> p.getSex().equals(Person.Sex.MAN)
                ? p.getAge() <= maleToAge : p.getAge() <= femaleToAge;
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge)
                .filter(personChecker)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        List<Person> filteredList =
                selectPersonByAgeAndSex(peopleList, femaleAge, HUMAN_MAX_AGE, Person.Sex.WOMAN);
        return filteredList.stream()
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Person> selectPersonByAgeAndSex(List<Person> list,
                                                 int fromAge, int toAge, Person.Sex sex) {
        return list.stream()
                .filter(p -> p.getSex().equals(sex) && p.getAge() <= toAge && p.getAge() >= fromAge)
                .collect(Collectors.toList());
    }
}
