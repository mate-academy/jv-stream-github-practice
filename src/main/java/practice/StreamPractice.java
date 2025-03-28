package practice;

import model.Candidate;
import model.Cat;
import model.Person;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Stream.of(s.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {

        return IntStream.range(0, numbers.size())
                .mapToObj(i -> (i % 2 == 1) ? numbers.get(i) - 1 : numbers.get(i))
                .mapToInt(Integer::intValue)
                .filter(i -> i % 2 == 1)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {

        return peopleList.stream()
                .filter(s -> s.getSex().equals(Person.Sex.MAN))
                .filter(s -> s.getAge() >= fromAge)
                .filter(s -> s.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> {
                    int age = person.getAge();
                    Person.Sex sex = person.getSex();
                    return age >= fromAge
                            && ((sex == Person.Sex.MAN && age <= maleToAge)
                            || (sex == Person.Sex.WOMAN && age <= femaleToAge));
                })
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {

        return peopleList.stream()
                .filter(s -> s.getSex().equals(Person.Sex.WOMAN))
                .filter(s -> s.getAge() >= femaleAge)
                .flatMap(s -> s.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator validator = new CandidateValidator();

        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
