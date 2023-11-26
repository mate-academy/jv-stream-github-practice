package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String SPLIT_STRING_REGEX = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(string -> string.split(SPLIT_STRING_REGEX))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(this::isEven)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        System.out.println(numbers);
        return IntStream.range(0, numbers.size())
                .map(index -> isEven(index) ? numbers.get(index) : numbers.get(index) - 1)
                .filter(number -> !isEven(number))
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> Person.Sex.MAN.equals(person.getSex())
                        && person.getAge() >= fromAge && person.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> validatePerson(person, fromAge, maleToAge, femaleToAge))
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> Person.Sex.WOMAN.equals(person.getSex())
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
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

    private boolean validatePerson(Person person, int fromAge, int maleToAge, int femaleToAge) {
        int age = person.getAge();
        Person.Sex sex = person.getSex();
        return Person.Sex.MAN.equals(sex)
                && age >= fromAge && age <= maleToAge
                || Person.Sex.WOMAN.equals(sex)
                && age >= fromAge && age <= femaleToAge;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
