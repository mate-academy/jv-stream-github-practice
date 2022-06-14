package practice;

import java.util.Arrays;
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
        return numbers.stream()
                .flatMap(n -> Arrays.stream(n.replaceAll(" ", "").split(","))
                .map(Integer::valueOf))
                .filter(x -> x % 2 == 0)
                .min(Integer::compare)
                .orElseThrow(()
                        -> new RuntimeException(
                        "Can't get min value from list: method_input_list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(n -> n % 2 != 0 ? numbers.get(n) - 1 : numbers.get(n))
                .filter(n -> n % 2 != 0)
                .mapToDouble(Double::valueOf)
                .average()
                .orElseThrow(() -> new NoSuchElementException("No element to operate!"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.MAN)
                        && p.getAge() >= fromAge
                        && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicate = p -> p.getAge() >= fromAge
                && ((p.getSex().equals(Person.Sex.MAN)
                && p.getAge() <= maleToAge)
                || (p.getSex().equals(Person.Sex.WOMAN) && p.getAge() <= femaleToAge));
        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.WOMAN) && p.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(p -> new CandidateValidator().test(p))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
