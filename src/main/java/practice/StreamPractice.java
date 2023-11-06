package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String COMMA = ",";
    private final CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
            .flatMap(s -> Arrays.stream(s.split(COMMA)))
            .mapToInt(Integer::parseInt)
            .filter(n -> (n % 2 == 0))
            .min()
            .orElseThrow(() -> new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
            .map(i -> isOddNumber(i) ? numbers.get(i) - 1 : numbers.get(i))
            .filter(this::isOddNumber)
            .mapToDouble(Double::valueOf)
            .average()
            .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
            .filter(person -> person.getSex() == Person.Sex.MAN
                && fromAge < person.getAge() && person.getAge() <= toAge)
            .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
            .filter(person -> (person.getSex() == Person.Sex.MAN
                && fromAge <= person.getAge() && person.getAge() <= maleToAge)
                || (person.getSex() == Person.Sex.WOMAN
                && fromAge <= person.getAge()
                && person.getAge() <= femaleToAge))
            .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
            .filter(person -> person.getAge() >= femaleAge && !person.getName().isEmpty()
                && person.getSex() == Person.Sex.WOMAN
                && !person.getCats().isEmpty())
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
