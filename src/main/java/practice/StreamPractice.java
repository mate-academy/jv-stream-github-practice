package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String COMMA = ",";
    private final CandidateValidator validator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(string -> string.split(COMMA))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(this::isEven)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        int subtractNumber = 1;

        return IntStream.range(0, numbers.size())
                .map(number -> !isEven(number)
                        ? numbers.get(number) - subtractNumber
                        : numbers.get(number))
                .filter(number -> !isEven(number))
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> isManValid(person, fromAge, toAge))
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> isPersonWorkable(person, fromAge, femaleToAge, maleToAge))
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> isValidCatOwner(person, femaleAge))
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    private boolean isManValid(Person person, int fromAge, int toAge) {
        return person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }

    private boolean isPersonWorkable(Person person, int fromAge, int femaleToAge, int maleToAge) {
        return person.getAge() >= fromAge
                && ((person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge)
                || (person.getSex() == Person.Sex.WOMAN && person.getAge() <= femaleToAge));
    }

    private static boolean isValidCatOwner(Person person, int femaleAge) {
        return person.getSex() == Person.Sex.WOMAN
                && !person.getCats().isEmpty()
                && person.getAge() >= femaleAge;
    }
}
