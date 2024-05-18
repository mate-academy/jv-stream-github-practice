package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        Stream<String> stringStream = numbers.stream();
        return stringStream.map(s -> s.split(","))
                .map((stringArr) -> {
                    Stream<String> innerStream = Arrays.stream(stringArr);
                    Optional<Integer> minFromArr = innerStream.map(Integer::parseInt)
                            .min(Integer::compare);
                    return minFromArr.get();
                })
                .filter(value -> value % 2 == 0)
                .min(Integer::compare)
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map((index) -> {
                    if (index % 2 != 0) {
                        return numbers.get(index) - 1;
                    }
                    return numbers.get(index);
                }).filter(value -> value % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Stream<Person> stream = peopleList.stream();
        return stream.filter(person -> person.getAge() >= fromAge
                        && person.getAge() <= toAge
                        && person.getSex().equals(Person.Sex.MAN))
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Stream<Person> stream = peopleList.stream();
        return stream.filter((person) -> {
            if (person.getSex().equals(Person.Sex.MAN)) {
                return person.getAge() >= fromAge && person.getAge() <= maleToAge;
            }
            if (person.getSex().equals(Person.Sex.WOMAN)) {
                return person.getAge() >= fromAge && person.getAge() <= femaleToAge;
            }
            return false;
        })
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Stream<Person> stream = peopleList.stream();
        return stream.filter(person -> person.getSex().equals(Person.Sex.WOMAN)
                        && person.getAge() >= femaleAge)
                .map((person) -> {
                    List<Cat> cats = person.getCats();
                    Stream<Cat> stream1 = cats.stream();
                    return stream1.map(Cat::getName).toList();
                })
                .flatMap(List::stream)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        Stream<Candidate> stream = candidates.stream();
        CandidateValidator candidateValidator = new CandidateValidator();
        return stream.filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
