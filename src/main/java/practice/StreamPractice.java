package practice;

import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    private final CandidateValidator candidateValidator;

    public StreamPractice() {
        this.candidateValidator = new CandidateValidator();
    }

    public int findMinEvenNumber(List<String> numbers) {
        OptionalInt min = numbers.stream()
                .map(e -> e.split(","))
                .flatMap(Stream::of)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .filter(e -> e % 2 == 0)
                .min();
        return min.orElseThrow(
                () -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(e -> e % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(e -> e.getAge() >= fromAge
                        && e.getAge() <= toAge
                        & e.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(e -> (e.getAge() >= fromAge
                        && e.getAge() <= maleToAge
                        && e.getSex() == Person.Sex.MAN)
                        || (e.getAge() >= fromAge
                        && e.getAge() <= femaleToAge
                        && e.getSex() == Person.Sex.WOMAN))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(e -> e.getAge() >= femaleAge
                        && e.getSex() == Person.Sex.WOMAN)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
