package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {
    private static final int DIVIDER = 2;
    private static final int ZERO = 0;
    private static final String SEPARATOR = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(string -> string.split(SEPARATOR))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(number -> number % DIVIDER == ZERO)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(iter -> iter % DIVIDER != ZERO
                        ? Math.decrementExact(numbers.get(iter)) : numbers.get(iter))
                .filter(number -> number % DIVIDER != ZERO)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }
    
    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> ((person.getSex() == Person.Sex.MAN
                        && person.getAge() <= maleToAge)
                        || (person.getSex() == Person.Sex.WOMAN
                        && person.getAge() <= femaleToAge)) && person.getAge() >= fromAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(cats -> cats.stream()).map(cat -> cat.getName())
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator predicate = new CandidateValidator();
        return candidates.stream()
                .filter(predicate)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
