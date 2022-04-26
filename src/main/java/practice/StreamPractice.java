package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {

        return numbers.stream()
                .flatMap(x -> Arrays.stream(x.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + "< Here is our input 'numbers' >"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {

        return numbers.stream()
                .map(x -> numbers.indexOf(x) % 2 != 0 ? x - 1 : x)
                .mapToInt(Integer::intValue)
                .filter(x -> x % 2 != 0)
                .distinct()
                .average().orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(x -> x.getSex() == Person.Sex.MAN
                        && x.getAge() > fromAge && x.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(x -> x.getSex() == Person.Sex.MAN
                        ? x.getAge() >= fromAge && x.getAge() <= maleToAge
                        : x.getAge() >= fromAge && x.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {

        return peopleList.stream()
                .filter(x -> !x.getCats().isEmpty()
                        && x.getSex() == Person.Sex.WOMAN && x.getAge() >= femaleAge)
                .flatMap(x -> x.getCats().stream())
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
