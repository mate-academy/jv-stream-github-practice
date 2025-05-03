package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String RUNTIME_EXCEPTION_MESSAGE = "Can't get min value from list: ";
    private static final String SEPARATOR = ",";
    private Predicate<Integer> predicateIfOdd = num -> num % 2 != 0;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(num -> Arrays.stream(num.split(SEPARATOR))
                        .map(Integer::parseInt)
                        .filter(n -> n % 2 == 0))
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException(RUNTIME_EXCEPTION_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> predicateIfOdd.test(index)
                        ? numbers.get(index) - 1 : numbers.get(index))
                .filter(predicateIfOdd::test)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() > fromAge && person.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList
                .stream()
                .filter(people -> people.getAge() >= fromAge
                        && people.getAge()
                        <= (people.getSex() == Person.Sex.MAN
                        ? maleToAge : femaleToAge)
                ).toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= femaleAge
                        && person.getSex() == Person.Sex.WOMAN)
                .map(Person::getCats)
                .flatMap(List::stream)
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates
                .stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
