package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(number -> isEven(number))
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(num -> subtractFromOddPosition(numbers, num))
                .filter(number -> !isEven(number))
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> isValidMaleUser(person, fromAge, toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> isValidFemaleUser(person, fromAge, femaleToAge)
                        || isValidMaleUser(person, fromAge, maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> isFemaleOldEnough(person, femaleAge))
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidate -> candidateValidator.test(candidate))
                .map(Candidate::getName)
                .sorted()
                .toList();
    }

    private <T extends Number> boolean isEven(T number) {
        return number.doubleValue() % 2 == 0;
    }

    private int subtractFromOddPosition(List<Integer> list, int number) {
        return !isEven(number) ? list.get(number) - 1 : list.get(number);
    }

    private boolean isValidMaleUser(Person person, int fromAge, int toAge) {
        return person.getSex().equals(Person.Sex.MAN)
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }

    private boolean isValidFemaleUser(Person person, int fromAge, int toAge) {
        return person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }

    private boolean isFemaleOldEnough(Person person, int fromAge) {
        return person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= fromAge;
    }
}
