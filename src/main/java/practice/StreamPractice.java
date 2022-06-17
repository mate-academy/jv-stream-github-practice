package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public static final String DELIMITER = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(n -> n.split(DELIMITER))
                .flatMap(Arrays::stream)
                .map(Integer::valueOf)
                .filter(x -> x % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: method_input_list"
                                + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::valueOf)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> Person.Sex.MAN.equals(p.getSex())
                        && p.getAge() >= fromAge
                        && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> Person.Sex.MAN == p.getSex()
                        && p.getAge() <= maleToAge
                        && p.getAge() >= fromAge
                        || Person.Sex.WOMAN == p.getSex()
                        && p.getAge() <= femaleToAge
                        && p.getAge() >= fromAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> Person.Sex.WOMAN == p.getSex()
                        && p.getAge() > femaleAge)
                .flatMap(x -> x.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
