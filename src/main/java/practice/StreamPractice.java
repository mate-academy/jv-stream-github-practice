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
    private static final String COMA_REGAX = ",";
    private static final int SUBTRACT = 1;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMapToInt(number -> Arrays.stream(number.split(COMA_REGAX))
                        .mapToInt(Integer::parseInt))
                .filter(this::isEven)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                 .map(index -> isEven(index) ? numbers.get(index) : numbers.get(index) - SUBTRACT)
                 .filter(number -> !isEven(number))
                 .average()
                 .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> predicate = createAgePredicate(fromAge, toAge);

        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicate = createAgeAndGenderPredicate(fromAge, maleToAge, femaleToAge);

        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> womanPredicate = createWomanPredicate(femaleAge);

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

    public Predicate<Person> createWomanPredicate(int femaleAge) {
        return person -> person.getSex() == Person.Sex.WOMAN && person.getAge() >= femaleAge;
    }

    private Predicate<Person> createAgeAndGenderPredicate(
            int fromAge, int maleToAge, int femaleToAge) {
        return person -> {
            int genderAge = person.getSex() == Person.Sex.MAN ? maleToAge : femaleToAge;
            return person.getAge() >= fromAge && person.getAge() <= genderAge;
        };
    }

    private Predicate<Person> createAgePredicate(int fromAge, int toAge) {
        return person -> person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge && person.getAge() <= toAge;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
