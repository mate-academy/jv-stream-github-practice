package practice;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String COMA_REGAX = ",";
    private static final int SUBTRACT = 1;

    public int findMinEvenNumber(List<String> numbers) {
        OptionalInt integer = numbers.stream()
                .flatMap(number -> Arrays.stream(number.split(COMA_REGAX)))
                .map(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .min();

        return integer.orElseThrow(() ->
                new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                 .map(index -> isEven(index) ? numbers.get(index) : numbers.get(index) - SUBTRACT)
                 .filter(number -> !isEven(number))
                 .average()
                 .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> predicate = person -> person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge && person.getAge() <= toAge;

        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicate = person -> {
            int genderAge = person.getSex() == Person.Sex.MAN ? maleToAge : femaleToAge;
            return person.getAge() >= fromAge && person.getAge() <= genderAge;
        };

        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> womanPredicate = person -> person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge;

        return peopleList.stream()
                .filter(womanPredicate)
                .flatMap(person -> person.getCats().stream())
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

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
