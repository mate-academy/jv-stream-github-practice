package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String COMMA = ",";
    private static final String EXCEPTION_MESSAGE = "Can't get min value from list: ";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(string -> string.split(COMMA))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(number -> !checkIfOdd(number))
                .min()
                .orElseThrow(() ->
                        new RuntimeException(EXCEPTION_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(ZERO, numbers.size())
                .map(index -> checkIfOdd(index) ? numbers.get(index) - ONE : numbers.get(index))
                .filter(this::checkIfOdd)
                .average()
                .getAsDouble();
    }

    private boolean checkIfOdd(int number) {

        return number % TWO != ZERO;
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> filterManByAge = person -> {
            int age = person.getAge();
            Person.Sex sex = person.getSex();
            return Person.Sex.MAN == sex
                    && age >= fromAge
                    && age <= toAge;
        };

        return peopleList.stream()
                .filter(filterManByAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> filterPersonBySexAndAge = person -> {
            int age = person.getAge();
            Person.Sex sex = person.getSex();
            return age >= fromAge
                    && (Person.Sex.WOMAN == sex && age <= femaleToAge
                    || Person.Sex.MAN == sex && age <= maleToAge);
        };
        return peopleList.stream()
                .filter(filterPersonBySexAndAge)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
