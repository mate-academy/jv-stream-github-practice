package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String DELIMITER = ",";
    private static final int SUBTRAHEND = 1;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(DELIMITER))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        Predicate<Integer> isOdd = number -> number % 2 == 1;
        IntFunction<Integer> getNumber =
                index -> (isOdd.test(index))
                        ? numbers.get(index) - SUBTRAHEND : numbers.get(index);
        return IntStream.range(0, numbers.size())
                .mapToObj(getNumber)
                .filter(isOdd)
                .mapToInt(n -> n)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> isMenInAgeBounds = person -> person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
        return peopleList.stream()
                .filter(isMenInAgeBounds)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> isPersonWorkable =
                person -> person.getAge() >= fromAge
                        && ((person.getSex() == Person.Sex.MAN
                        && person.getAge() <= maleToAge)
                        || (person.getSex() == Person.Sex.WOMAN
                        && person.getAge() <= femaleToAge));
        return peopleList.stream()
                .collect(Collectors.filtering(isPersonWorkable, Collectors.toList()));
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> isWomenFromAgeAndHasCat =
                person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge
                        && !person.getCats().isEmpty();
        return peopleList.stream()
                .filter(isWomenFromAgeAndHasCat)
                .flatMap(w -> w.getCats().stream())
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
