package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(n -> n.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::valueOf)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(integer -> integer % 2 == 1)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(n -> n.getSex() == (Person.Sex.MAN))
                .filter(n -> n.getAge() >= fromAge && n.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN && p.getAge() >= fromAge
                        && p.getAge() <= maleToAge
                        || p.getSex() == Person.Sex.WOMAN && p.getAge() >= fromAge
                        && p.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(List::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .filter(candidate -> candidate.getAge() >= 35)
                .filter(candidate -> candidate.getNationality().equals("Ukrainian"))
                .filter(candidate -> candidate.isAllowedToVote())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
