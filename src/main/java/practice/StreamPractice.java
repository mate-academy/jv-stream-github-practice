package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public static final String NO_ELEMENT_MESSAGE = "No odd numbers in the list or empty list.";
    public static final String CANT_GET_VALUE_MESSAGE = "Can't get min value from list: ";
    private static final String DIVIDER = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(n -> n.split(DIVIDER))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::valueOf)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(CANT_GET_VALUE_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(f -> f % 2 != 0)
                .mapToDouble(d -> d)
                .average()
                .orElseThrow(() -> new NoSuchElementException(NO_ELEMENT_MESSAGE));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> isManByAgeMatchInclusive(fromAge, toAge, p))
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> personFitsAge(fromAge, femaleToAge, maleToAge, p))
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> conditionForCatNames(femaleAge, p))
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator validator = new CandidateValidator();
        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }

    private boolean conditionForCatNames(int femaleAge, Person p) {
        return p.getAge() >= femaleAge && p.getSex() == Person.Sex.WOMAN;
    }

    private boolean isManByAgeMatchInclusive(int fromAge, int toAge, Person p) {
        return p.getAge() <= toAge
                && p.getAge() >= fromAge
                && p.getSex() == Person.Sex.MAN;
    }

    private boolean personFitsAge(int fromAge, int femaleToAge,
                                  int maleToAge, Person p) {
        return p.getAge() <= maleToAge
                && p.getAge() >= fromAge
                && p.getSex() == Person.Sex.MAN
                || p.getAge() <= femaleToAge
                && p.getAge() >= fromAge
                && p.getSex() == Person.Sex.WOMAN;
    }
}
