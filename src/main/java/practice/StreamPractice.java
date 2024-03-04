package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min(Integer::compare)
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(i -> (i % 2 == 1) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 == 1)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge
                        && person.getAge() <= toAge
                        && person.getSex() == Person.Sex.MAN)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge
                        && ((person.getSex() == Person.Sex.MAN
                        && person.getAge() <= maleToAge)
                        || ((person.getSex() == Person.Sex.WOMAN
                        && person.getAge() <= femaleToAge))))
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList,
                                     int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= femaleAge
                        && person.getSex() == Person.Sex.WOMAN)
                .flatMap(person -> person.getCats().stream())
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
