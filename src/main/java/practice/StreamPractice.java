package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String COMMA = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
          .flatMap(s -> Arrays.stream(s.split(COMMA)))
          .mapToInt(Integer::parseInt)
          .filter(i -> i % 2 == 0)
          .min()
          .orElseThrow(() -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
          .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
          .filter(i -> i % 2 != 0)
          .average()
          .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
          .filter(p -> p.getAge() >= fromAge && p.getAge() <= toAge
                && p.getSex() == Person.Sex.MAN)
          .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
          .filter(p -> p.getAge() >= fromAge
                && ((p.getSex() == Person.Sex.WOMAN && p.getAge() <= femaleToAge)
                        || (p.getSex() == Person.Sex.MAN && p.getAge() <= maleToAge)))
          .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
          .filter(p -> p.getAge() >= femaleAge && p.getSex() == Person.Sex.WOMAN)
          .flatMap(person -> person.getCats().stream())
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
