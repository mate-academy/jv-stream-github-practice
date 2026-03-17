package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        Stream<String> stream = numbers.stream();
        OptionalInt result = stream.map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min();
        return result.orElseThrow(() -> new RuntimeException("Can't get min"
                + " value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException("No odd numbers in the list"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Stream<Person> stream = peopleList.stream();

        return stream.filter(person -> person.getSex() == Person.Sex.MAN)
                .filter(p -> p.getAge() >= fromAge && p.getAge() <= toAge)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Stream<Person> stream = peopleList.stream();
        return stream.filter(person -> (person.getSex() == Person.Sex.WOMAN
                        && person.getAge() <= femaleToAge
                        && person.getAge() >= fromAge)
                        || (person.getSex() == Person.Sex.MAN
                        && person.getAge() <= maleToAge
                        && person.getAge() >= fromAge))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Stream<Person> stream = peopleList.stream();
        return stream.filter(p -> p.getSex() == Person.Sex.WOMAN)
                .filter(p -> p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(cat -> cat.getName())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        Stream<Candidate> stream = candidates.stream();
        return stream.filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}


