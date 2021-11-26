package practice;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        int findMinNumber = numbers.stream()
                .flatMap(n -> Stream.of(n.split(",")))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .mapToInt(v -> v)
                .min().orElseThrow(() -> new RuntimeException("Can't get min value from list"));
        return findMinNumber;
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        List<Person> menByAge = peopleList.stream()
                .filter(p -> p.getAge() >= fromAge && p.getAge() <= toAge && p.getSex()
                        .equals(Person.Sex.MAN))
                .collect(Collectors.toList());
        return menByAge;
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        List<Person> workablePople = peopleList.stream()
                .filter(p -> p.getAge() >= fromAge)
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && p.getAge() <= maleToAge
                        || p.getSex() == Person.Sex.WOMAN
                        && p.getAge() <= femaleToAge)
                .collect(Collectors.toList());
        return workablePople;
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        List<String> catsNames = peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.WOMAN) && p.getAge() >= femaleAge)
                .map(p -> p.getCats())
                .flatMap(p -> p.stream())
                .map(c -> c.getName())
                .collect(Collectors.toList());
        return catsNames;
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        Predicate<Candidate> candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(c -> c.getName())
                .sorted()
                .collect(Collectors.toList());
    }
}
