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

public class StreamPractice {
    private static final String DELIMETR = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(x -> x.split(DELIMETR))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .sorted()
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(x -> x % 2 != 0 ? numbers.get(x) - 1 : numbers.get(x))
                .filter(x -> x % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(x -> x.getSex() == Person.Sex.MAN
                        && x.getAge() >= fromAge && x.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicatePerson = person -> (person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge && person.getAge() <= maleToAge)
                || (person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= fromAge && person.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(predicatePerson)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(x -> x.getSex() == Person.Sex.WOMAN && x.getAge() >= femaleAge)
                .flatMap(x -> x.getCats().stream())
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
