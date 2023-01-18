package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        try {
            return numbers.stream()
                    .map(e -> e.split(","))
                    .flatMap(Arrays::stream)
                    .mapToInt(Integer::parseInt)
                    .filter(n -> n % 2 == 0)
                    .min()
                    .getAsInt();
        } catch (RuntimeException e) {
            throw new RuntimeException("Can't get min value from list: " + numbers);
        }
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        try {
            return IntStream.range(0, numbers.size())
                    .map(n -> n % 2 == 0 ? numbers.get(n) : numbers.get(n) - 1)
                    .filter(n -> n % 2 != 0)
                    .average()
                    .getAsDouble();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No such element in the list " + numbers);
        }
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex().equals(Person.Sex.MAN)
                        && person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> (person.getSex().equals(Person.Sex.MAN)
                        && person.getAge() >= fromAge && person.getAge() <= maleToAge)
                        || (person.getSex().equals(Person.Sex.WOMAN)
                        && person.getAge() >= fromAge && person.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex().equals(Person.Sex.WOMAN)
                        && person.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
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
}
