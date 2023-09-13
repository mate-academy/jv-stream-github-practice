package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(i -> i.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 == 1)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> menAgePredicate  = person ->
                person.getSex() == Person.Sex.MAN
                        && person.getAge() > fromAge
                        && person.getAge() <= toAge;

        return peopleList.stream()
                .filter(menAgePredicate )
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> workingMenPredicate = person ->
                person.getSex() == Person.Sex.MAN && person.getAge() >= fromAge
                        && person.getAge() <= maleToAge;

        Predicate<Person> workingWomenPredicate = person ->
                person.getSex() == Person.Sex.WOMAN && person.getAge() >= fromAge
                        && person.getAge() <= femaleToAge;

        return peopleList.stream()
                .filter(workingMenPredicate.or(workingWomenPredicate))
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person ->
                        person.getSex() == Person.Sex.WOMAN
                                && person.getAge() >= femaleAge)
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
