package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final int DIVIDER = 2;
    private static final int SUBTRACTOR = 1;

    public int findMinEvenNumber(List<String> numbers) {

        return numbers.stream()
                .flatMap(num -> Arrays.stream(num.split(",")))
                .map(Integer::parseInt)
                .filter(num -> num % DIVIDER == 0)
                .min(Integer::compareTo)
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(index ->
                        (index % DIVIDER != 0)
                                ? numbers.get(index) - SUBTRACTOR : numbers.get(index))
                .filter(num -> num % DIVIDER != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> {
                    if (person.getSex() == Person.Sex.MAN) {
                        return (person.getAge() >= fromAge && person.getAge() <= maleToAge);
                    } else if (person.getSex() == Person.Sex.WOMAN) {
                        return (person.getAge() >= fromAge && person.getAge() <= femaleToAge);
                    }
                    return false;
                })
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person ->
                        person.getSex() == Person.Sex.WOMAN && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator validator = new CandidateValidator();
        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
