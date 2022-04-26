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

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(m -> m.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: "
                                + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {

        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                .filter(i -> i % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(i -> i.getSex() == Person.Sex.MAN
                        && i.getAge() >= fromAge
                        && i.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(i -> (i.getSex() == Person.Sex.MAN
                        && i.getAge() <= maleToAge
                        && i.getAge() >= fromAge)
                        || (i.getSex() == Person.Sex.WOMAN
                        && i.getAge() <= femaleToAge
                        && i.getAge() >= fromAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {

        return peopleList.stream()
                .filter(i -> i.getSex() == Person.Sex.WOMAN && i.getAge() >= femaleAge)
                .flatMap(i -> i.getCats().stream())
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
