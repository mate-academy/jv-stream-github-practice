package practice;

import java.util.Collection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private final CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
            .flatMap(s -> Arrays.stream(s.split(",")))
            .mapToInt(Integer::parseInt)
            .filter(n -> (n % 2 == 0))
            .min()
            .orElseThrow(() -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
            .map(i -> isOddNumber(i) ? numbers.get(i) - 1 : numbers.get(i))
            .filter(n -> (n % 2 == 1))
            .mapToDouble(Double::valueOf)
            .average()
            .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
            .filter(p -> p.getSex() == Person.Sex.MAN
                && fromAge < p.getAge() && p.getAge() <= toAge)
            .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
            .filter(p -> (p.getSex() == Person.Sex.MAN
                && fromAge <= p.getAge() && p.getAge() <= maleToAge)
                || (p.getSex() == Person.Sex.WOMAN
                && fromAge <= p.getAge()
                && p.getAge() <= femaleToAge))
            .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
            .filter(p -> p.getAge() >= femaleAge && !p.getName().isEmpty()
                && p.getSex() == Person.Sex.WOMAN
                && !p.getCats().isEmpty())
            .map(Person::getCats)
            .flatMap(Collection::stream)
            .map(Cat::getName)
            .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
            .filter(candidateValidator)
            .map(Candidate::getName)
            .sorted()
            .toList();
    }

    private boolean isOddNumber(int number) {
        return number % 2 == 1;
    }
}
