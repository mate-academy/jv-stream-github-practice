package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String SEPARATOR = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(lineNumbers -> lineNumbers.split(SEPARATOR))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> (index % 2 == 1) ? numbers.get(index) - 1 : numbers.get(index))
                .filter(number -> number % 2 == 1)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(poorMan -> poorMan.getSex() == Person.Sex.MAN
                        && poorMan.getAge() >= fromAge
                        && poorMan.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(people -> people.getAge() >= fromAge)
                .filter(people -> people.getSex() == Person.Sex.MAN
                        ? people.getAge() <= maleToAge
                        : people.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(people -> people.getSex() == Person.Sex.WOMAN && people.getAge() >= femaleAge)
                .flatMap(woman -> woman.getCats().stream())
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
