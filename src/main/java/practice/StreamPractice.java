package practice;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String MIN_VALUE_ERROR_MESSAGE = "Can't get min value from list: %s";
    private static final String COMMA = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(str -> Stream.of(str.split(COMMA)))
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        String.format(MIN_VALUE_ERROR_MESSAGE, numbers)));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(num -> isOdd(num) ? numbers.get(num) - 1 : numbers.get(num))
                .filter(n -> isOdd((int) n))
                .average()
                .getAsDouble();
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex().equals(Person.Sex.MAN)
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {

        Predicate<Person> personCheck = person -> {
            int age = person.getAge();
            Person.Sex sex = person.getSex();
            return age >= fromAge
                    && (Person.Sex.MAN.equals(sex) && age <= maleToAge
                    || Person.Sex.WOMAN.equals(sex) && age <= femaleToAge);
        };
        return peopleList.stream()
                .filter(personCheck)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= femaleAge
                        && person.getSex().equals(Person.Sex.WOMAN))
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
