package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String SPLITTERATOR = ",";
    private static final String EXCEPTION_MESSAGE = "Can't get min value from list: ";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(SPLITTERATOR))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min().orElseThrow(() -> new RuntimeException(EXCEPTION_MESSAGE
                             + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(n -> n % 2 != 0 ? numbers.get(n) - 1 : numbers.get(n))
                .filter(n -> n % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(testPerson(fromAge, toAge, Person.Sex.MAN))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(canPersonWork(fromAge, femaleToAge, maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN && p.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
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

    private Predicate<Person> testPerson(int minAge, int maxAge, Person.Sex sex) {
        return (p) -> p.getAge() >= minAge && p.getAge() <= maxAge
                && p.getSex() == sex;
    }

    private Predicate<Person> canPersonWork(int fromAge, int femaleToAge, int maleToAge) {
        return (p) -> {
            if (p.getSex() == Person.Sex.MAN) {
                return p.getAge() >= fromAge && p.getAge() <= maleToAge;
            }
            return p.getAge() >= fromAge && p.getAge() <= femaleToAge;
        };
    }
}
