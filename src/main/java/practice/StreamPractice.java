package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    /**
     * Given list of strings where each element contains 1+ numbers:
     * input = {"5,30,100", "0,22,7", ...}
     * return min integer value. One more thing - we're interested in even numbers.
     * If there is no needed data throw RuntimeException with message
     * "Can't get min value from list: < Here is our input 'numbers' >"
     */
    public int findMinEvenNumber(List<String> numbers) {
        List<String> correctedList = numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .toList();
        List<Integer> integerList = correctedList.stream()
                .map(Integer::parseInt)
                .toList();
        Optional<Integer> correctNumber = integerList.stream()
                .filter(n -> n % 2 == 0)
                .min(Comparator.comparingInt(a -> a));
        if (correctNumber.isEmpty()) {
            throw new RuntimeException("Can't get min value from list: " + correctNumber);
        }
        return correctNumber.get();
    }

    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> oddIndexedNumbers = IntStream
                .range(0, numbers.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(numbers::get)
                .toList();
        List<Integer> subtractedOddIndexedNumbers = oddIndexedNumbers.stream()
                .map(n -> n - 1)
                .toList();
        List<Integer> evenIndexedNumbers = IntStream
                .range(0, numbers.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(numbers::get)
                .toList();
        List<Integer> correctedList = new ArrayList<>(subtractedOddIndexedNumbers);
        correctedList.addAll(evenIndexedNumbers);
        OptionalDouble optional = correctedList.stream()
                .filter(n -> n % 2 != 0)
                .mapToDouble(n -> Double.parseDouble(String.valueOf(n))).average();
        return optional.orElseThrow(NoSuchElementException::new);
    }

    /**
     * Given a List of `Person` instances (having `name`, `age` and `sex` fields),
     * for example, `Arrays.asList( new Person(«Victor», 16, Sex.MAN),
     * new Person(«Helen», 42, Sex.WOMAN))`,
     * select from the List only men whose age is from `fromAge` to `toAge` inclusively.
     * <p>
     * Example: select men who can be recruited to army (from 18 to 27 years old inclusively).
     */
    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.MAN))
                .filter(p -> p.getAge() >= fromAge)
                .filter(p -> p.getAge() <= toAge)
                .toList();
    }

    /**
     * Given a List of `Person` instances (having `name`, `age` and `sex` fields),
     * for example, `Arrays.asList( new Person(«Victor», 16, Sex.MAN),
     * new Person(«Helen», 42, Sex.WOMAN))`,
     * select from the List only people whose age is from `fromAge` and to `maleToAge` (for men)
     * or to `femaleToAge` (for women) inclusively.
     * <p>
     * Example: select people of working age
     * (from 18 y.o. and to 60 y.o. for men and to 55 y.o. for women inclusively).
     */
    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge)
                .filter(p -> p.getSex().equals(Person.Sex.MAN) && p.getAge() <= maleToAge
                        || p.getSex().equals(Person.Sex.WOMAN) && p.getAge() <= femaleToAge)
                .toList();
    }

    /**
     * Given a List of `Person` instances (having `name`, `age`, `sex` and `cats` fields,
     * and each `Cat` having a `name` and `age`),
     * return the names of all cats whose owners are women from `femaleAge` years old inclusively.
     */
    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        List<Person> filteredPersons = peopleList.stream()
                .filter(p -> p.getSex().equals(Person.Sex.WOMAN))
                .filter(p -> p.getAge() >= femaleAge)
                .toList();
        return filteredPersons.stream()
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .toList();
    }

    /**
     * Your help with a election is needed. Given list of candidates, where each element
     * has Candidate.class type.
     * Check which candidates are eligible to apply for president position and return their
     * names sorted alphabetically.
     * The requirements are: person should be older than 35 years, should be allowed to vote,
     * have nationality - 'Ukrainian'
     * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
     * which has following view: "2002-2015"
     * We want to reuse our validation in future, so let's write our own impl of Predicate
     * parametrized with Candidate in CandidateValidator.
     */
    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
