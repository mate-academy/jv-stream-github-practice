package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMapToInt(s -> Arrays.stream(s.split(","))
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 2 == 0))
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> (i % 2 == 1) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(num -> num % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> isManBetweenAges = PersonValidator
                .isManBetweenAges(fromAge, toAge);

        return peopleList.stream()
                .filter(isManBetweenAges)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> workablePersonPredicate = PersonValidator
                .selectPeopleByAge(fromAge, maleToAge, femaleToAge);

        return peopleList.stream()
                .filter(workablePersonPredicate)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> elderlyWomanPredicate = PersonValidator
                .isElderlyWoman(femaleAge);

        return peopleList.stream()
                .filter(elderlyWomanPredicate)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
