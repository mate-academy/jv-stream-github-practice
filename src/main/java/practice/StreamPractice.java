package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap((s) -> Arrays.stream(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                                                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return (double) Math.round(IntStream.range(0, numbers.size())
                .mapToDouble((i) -> (i % 2 != 0) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 != 0)
                .average()
                .getAsDouble());
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList
                .stream()
                .filter(p -> (p.getAge() >= fromAge && p.getAge() <= toAge)
                            && p.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> peopleValidator = person ->
                (((person.getSex() == Person.Sex.WOMAN) && (person.getAge() <= femaleToAge))
                || ((person.getSex() == Person.Sex.MAN) && (person.getAge() <= maleToAge)))
                && (person.getAge() >= fromAge);

        return peopleList.stream()
                .filter(peopleValidator)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> (p.getSex() == Person.Sex.WOMAN) && (p.getAge() >= femaleAge)
                        && (!p.getCats().isEmpty()))
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(c -> new CandidateValidator().test(c))
                .map(Candidate::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
