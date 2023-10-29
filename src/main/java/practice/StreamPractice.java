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
    private static final String MIN_VALUE_NOT_FOUND = "Can't get min value from list: ";
    private static final String AVERAGE_VALUE_NOT_FOUND = "Can't get average value from list: ";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(split -> split.split(","))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .sorted()
                .findFirst()
                .orElseThrow(() -> new RuntimeException(MIN_VALUE_NOT_FOUND + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> filterListNumbers = IntStream.range(0, numbers.size())
                .mapToObj(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .toList();
        return filterListNumbers.stream()
                .filter(num -> num % 2 == 1)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException(AVERAGE_VALUE_NOT_FOUND + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge
                        && person.getAge() <= toAge
                        && person.getSex() == Person.Sex.MAN)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = person -> {
            if (person.getAge() >= fromAge) {
                if (person.getSex() == Person.Sex.WOMAN && person.getAge() <= femaleToAge) {
                    return true;
                }
                return person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge;
            }
            return false;
        };
        return peopleList.stream()
                .filter(personPredicate)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {

        return peopleList.stream()
                .filter(women -> women.getSex() == Person.Sex.WOMAN && women.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
