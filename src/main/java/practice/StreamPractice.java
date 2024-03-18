package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String SPLITTER = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(this::getSplitter)
                .mapToInt(Integer::parseInt)
                .filter(this::isEven)
                .min()
                .orElseThrow(() -> new NoSuchElementException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> isOdd(index) ? numbers.get(index) - 1 : numbers.get(index))
                .filter(this::isOdd)
                .average()
                .orElseThrow(() -> new NoSuchElementException("No odd numbers at "
                        + "odd positions in the list."));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> isMan(person)
                        && isFromAge(fromAge, person)
                        && isToAge(toAge, person))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> isFromAge(fromAge, person)
                        && (isMan(person) && isToAge(maleToAge, person)
                        || isWomen(person) && isToAge(femaleToAge, person)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> isWomen(person) && isFromAge(femaleAge, person))
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private Stream<String> getSplitter(String s) {
        return Arrays.stream(s.split(SPLITTER));
    }

    private boolean isEven(Integer n) {
        return n % 2 == 0;
    }

    private boolean isOdd(int n) {
        return !isEven(n);
    }

    private boolean isMan(Person person) {
        return person.getSex() == Person.Sex.MAN;
    }

    private boolean isWomen(Person person) {
        return person.getSex() == Person.Sex.WOMAN;
    }

    private boolean isToAge(int toAge, Person person) {
        return person.getAge() <= toAge;
    }

    private boolean isFromAge(int fromAge, Person person) {
        return person.getAge() >= fromAge;
    }
}
