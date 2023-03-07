package practice;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        OptionalInt first = numbers.stream()
                .map(s -> s.split(","))
                .flatMap(strings -> Arrays.stream(strings))
                .mapToInt(s -> parseInt(s))
                .sorted()
                .filter(i -> i % 2 == 0)
                .findFirst();
        return first.orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        OptionalDouble average = IntStream.range(0, numbers.size())
                .map(i -> {
                    if (i % 2 != 0) {
                        return numbers.get(i) - 1;
                    }
                    return numbers.get(i);
                }).filter(i -> i % 2 != 0)
                .average();
        return average.orElseThrow(() -> new NoSuchElementException());
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() > fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream().filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= fromAge && person.getAge() <= femaleToAge
                        || person.getSex() == Person.Sex.MAN && person.getAge()
                        >= fromAge && person.getAge() <= maleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats()
                        .stream()
                        .map(cat -> cat.getName()))
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator validator = new CandidateValidator();
        return candidates.stream().filter(validator::test)
                .map(p -> p.getName())
                .sorted()
                .collect(Collectors.toList());
    }
}
