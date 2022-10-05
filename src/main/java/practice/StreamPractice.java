package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public static final String REGEX = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(n -> Arrays.stream(n.split(REGEX)))
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(()
                        -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(integer -> integer % 2 == 1)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> selectMenByAge = p -> p.getSex() == Person.Sex.MAN
                && p.getAge() >= fromAge
                && p.getAge() <= toAge;
        return peopleList.stream()
                .filter(selectMenByAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> getWorkablePeople = p -> p.getAge() >= fromAge
                && ((p.getSex() == Person.Sex.MAN && p.getAge() <= maleToAge)
                || (p.getSex() == Person.Sex.WOMAN && p.getAge() <= femaleToAge));
        return peopleList.stream()
                .filter(getWorkablePeople)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> getCatsNamesWhereOwnerIsWoman = p -> p.getSex() == Person.Sex.WOMAN
                && p.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(getCatsNamesWhereOwnerIsWoman)
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
