package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final int NUMBER_TO_SUBTRACT = 1;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers
                .stream()
                .flatMap(string -> Arrays.stream(string.replaceAll(",", " ").split(" ")))
                .map(string -> string.matches("-?\\d+")
                        ? Integer.parseInt(string)
                        : -1)
                .mapToInt(number -> number)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: < Here is our input 'numbers' > "
                                + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        IntStream.range(0, numbers.size())
                .filter(integer -> integer % 2 != 0)
                .forEach(index -> numbers.set(index, numbers.get(index) - NUMBER_TO_SUBTRACT));
        return numbers
                .stream()
                .filter(integer -> integer % 2 != 0)
                .mapToDouble(Double::valueOf)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList
                .stream()
                .filter(person -> person.getSex().equals(Person.Sex.MAN)
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = person -> {
            return person.getSex().equals(Person.Sex.MAN)
                    ? (person.getAge() <= maleToAge && person.getAge() >= fromAge)
                    : (person.getAge() <= femaleToAge && person.getAge() >= fromAge);
        };
        return peopleList
                .stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList
                .stream()
                .filter(person -> Objects.equals(person.getSex(), Person.Sex.WOMAN)
                        && person.getCats() != null
                        && person.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates
                .stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
