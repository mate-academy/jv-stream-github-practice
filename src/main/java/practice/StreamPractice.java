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
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
            .flatMap(stringArray -> Arrays.stream(stringArray.split(",")))
            .mapToInt(Integer::parseInt)
            .filter(integer -> integer % 2 == 0)
            .min()
            .orElseThrow(() -> new RuntimeException(
                String.format("Can't get min value from list: < %s >", String.join(" ", numbers))));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
            .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
            .filter(integer -> integer % 2 != 0)
            .average()
            .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> personPredicate = person -> person.getAge() >= fromAge
                && person.getAge() <= toAge
                && person.getSex().equals(Sex.MAN);
        return peopleList.stream()
            .filter(personPredicate)
            .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
            int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = person -> {
            if (person.getAge() >= fromAge) {
                if (person.getSex().equals(Sex.MAN) && person.getAge() <= maleToAge) {
                    return true;
                }
                return person.getAge() <= femaleToAge;
            }
            return false;
        };
        return peopleList
            .stream()
            .filter(personPredicate)
            .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> predicate = person -> person.getAge() > femaleAge
                && person.getSex().equals(Sex.WOMAN);
        return peopleList.stream()
            .filter(predicate)
            .flatMap(human -> human.getCats().stream())
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
}
