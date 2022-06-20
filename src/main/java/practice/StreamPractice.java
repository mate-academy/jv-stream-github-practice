package practice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Stream.of(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get "
                        + "min value from list: < Here is our input 'numbers' >" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return Stream.iterate(0, n -> n + 1)
                .limit(numbers.size())
                .mapToInt(n -> n % 2 != 0 ? numbers.get(n) - 1 : numbers.get(n))
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Can't get "
                        + "average value from list: there is not valid numbers"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> validAge = person -> person.getAge() >= fromAge
                && person.getAge() <= toAge && person.getSex() == Person.Sex.MAN;
        return peopleList.stream()
                .filter(validAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> validWomanAndManAge = person -> person.getAge() >= fromAge
                && (person.getSex() == Person.Sex.MAN ? person.getAge() <= maleToAge
                : person.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(validWomanAndManAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> validWomanAge = person -> person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(validWomanAge)
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
}
