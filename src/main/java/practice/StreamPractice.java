package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String SEPARATOR = ",";
    private static final CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(n -> Arrays.stream(n.split(SEPARATOR)))
                .map(Integer::parseInt)
                .filter(n -> (n & 1) == 0)
                .min(Integer::compareTo)
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> {
                    Integer number = numbers.get(i);
                    return (i & 1) == 1 ? number - 1 : number;
                })
                .filter(n -> (n & 1) == 1)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                            && person.getAge() >= fromAge
                            && person.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> (person.getAge() >= fromAge)
                        && (person.getAge() <= (person.getSex() == Person.Sex.MAN
                        ? maleToAge
                        : femaleToAge)))
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                            && person.getAge() >= femaleAge)
                .flatMap(el -> el.getCats().stream())
                .map(Cat::getName)
                .distinct()
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
