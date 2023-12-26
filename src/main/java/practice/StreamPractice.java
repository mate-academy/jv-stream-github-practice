package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        List<String> strings = new ArrayList<>();
        for (String number : numbers) {
            strings.addAll(List.of(number.split(",")));
        }
        return strings.stream().map(Integer::parseInt).filter(n -> n % 2 == 0)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        Double result = IntStream.range(0, numbers.size())
                .mapToObj(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 == 1).collect(Collectors.averagingDouble(value -> value));
        if (result == 0) {
            throw new NoSuchElementException();
        }
        return result;
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> selectMenByAge =
                person -> person.getSex() == Person.Sex.MAN && person.getAge() >= fromAge
                        && person.getAge() <= toAge;
        return peopleList.stream().filter(selectMenByAge).collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge,
                                          List<Person> peopleList) {
        return peopleList.stream().filter(person ->
                (person.getSex() == Person.Sex.MAN && person.getAge() >= fromAge
                        && person.getAge() <= maleToAge)
                        ||
                        person.getSex() == Person.Sex.WOMAN
                                && person.getAge() >= fromAge
                                && person.getAge() <= femaleToAge).collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream().filter(person -> person.getAge() >= femaleAge
                        && person.getSex() == Person.Sex.WOMAN).map(Person::getCats)
                .flatMap(Collection::stream).map(Cat::getName).collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream().filter(new CandidateValidator()).map(Candidate::getName).sorted()
                .collect(Collectors.toList());
    }
}
