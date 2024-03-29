package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;
import model.PersonAgeAndSexPredicate;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(",")))
                .map(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .min(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Can't get min"
                        + " value from list:" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(index -> index % 2 == 1 ? numbers.get(index)
                        - 1 : numbers.get(index))
                .mapToInt(Integer::intValue)
                .filter(num -> num % 2 == 1)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        PersonAgeAndSexPredicate personAgeAndSexPredicate = new PersonAgeAndSexPredicate(
                fromAge, toAge, Person.Sex.MAN
        );
        return peopleList
                .stream()
                .filter(personAgeAndSexPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(
            int fromAge,
            int femaleToAge,
            int maleToAge,
            List<Person> peopleList
    ) {
        PersonAgeAndSexPredicate menAgePredicate = new PersonAgeAndSexPredicate(
                fromAge,
                maleToAge,
                Person.Sex.MAN
        );
        PersonAgeAndSexPredicate womenAgePredicate = new PersonAgeAndSexPredicate(
                fromAge, femaleToAge, Person.Sex.WOMAN
        );
        return peopleList.stream()
                .filter(womenAgePredicate.or(menAgePredicate))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        PersonAgeAndSexPredicate personAgeAndSexPredicate = new PersonAgeAndSexPredicate(
                femaleAge, 200, Person.Sex.WOMAN
        );
        return peopleList.stream()
                .filter(personAgeAndSexPredicate)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator validator = new CandidateValidator();
        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
