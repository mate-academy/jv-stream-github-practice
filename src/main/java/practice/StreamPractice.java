package practice;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String SPLITTER = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(num -> Stream.of(num.split(SPLITTER)))
                .mapToInt(Integer::parseInt)
                .filter(this::isEven)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list:" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> isOdd(i) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(this::isOdd)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> personPredicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge;
            }
        };
        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> personPredicate = person -> person.getAge() >= fromAge
                && person.getSex() == Person.Sex.MAN
                ? person.getAge() <= maleToAge
                : person.getAge() <= femaleToAge;
        return peopleList.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream().map(Cat::getName))
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

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}
