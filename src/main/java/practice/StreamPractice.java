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
                // turn each string in the list, into an Stream array of strings
                .flatMap(numStr -> Arrays.stream(numStr.split(",")))
                .map(Integer::parseInt)
                .filter(this::isEven)
                .min(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> isEven(index) ? numbers.get(index) : numbers.get(index) - 1)
                .boxed()
                .filter(this::isOdd)
                .mapToInt(integer -> integer)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> malesPredicate = person -> person.getSex().equals(Person.Sex.MAN)
                && (person.getAge() > fromAge
                && person.getAge() <= toAge);
        return peopleList.stream()
                .filter(malesPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> malesAndWomansPredicate = person ->
                (person.getSex().equals(Person.Sex.MAN)
                && person.getAge() >= fromAge
                && person.getAge() <= maleToAge)
                || (person.getSex().equals(Person.Sex.WOMAN)
                && person.getAge() >= fromAge
                && person.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(malesAndWomansPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> womanPredicate = person -> person.getSex().equals(Person.Sex.WOMAN)
                && person.getAge() > femaleAge;
        return peopleList.stream()
                .filter(womanPredicate)
                .map(Person::getCats)
                .flatMap(ownersCats -> ownersCats.stream())
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

    private boolean isOdd(int n) {
        return n % 2 != 0;
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }
}
