package practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(number -> Stream.of(number.split(",")))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(num -> num % 2 == 0 ? numbers.get(num) : numbers.get(num) - 1)
                .filter(num -> num % 2 != 0)
                .average().getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(people -> people.getSex().equals(Person.Sex.MAN)
                        && people.getAge() >= fromAge
                        && people.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(people -> (people.getSex() == Person.Sex.MAN
                        && people.getAge() >= fromAge
                        && people.getAge() <= maleToAge)
                        || (people.getSex() == Person.Sex.WOMAN
                        && people.getAge() >= fromAge
                        && people.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(e -> e.getSex().equals(Person.Sex.WOMAN) && e.getAge() >= femaleAge)
                .flatMap(e -> e.getCats().stream())
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
