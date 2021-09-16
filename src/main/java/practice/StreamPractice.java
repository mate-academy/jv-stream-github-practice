package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final int ZERO = 0;
    private static final int TWO = 2;
    private static final String EXCEPTION_NOTIFICATION
            = "Can't get min value from list with input: ";

    /**
     * Given list of strings where each element contains 1+ numbers:
     * input = {"5,30,100", "0,22,7", ...}
     * return min integer value. One more thing - we're interested in even numbers.
     * If there is no needed data throw RuntimeException with message
     * "Can't get min value from list: < Here is our input 'numbers' >"
     */
    public int findMinEvenNumber(List<String> numbers) {
        Optional<Integer> minEven = numbers.stream()
                .map(s -> s.split(","))
                .flatMap(number -> Arrays.stream(number.clone()))
                .map(number -> Integer.parseInt(number))
                .filter(integer -> integer.intValue() % TWO == ZERO)
                .min(Comparator.naturalOrder());
        return (minEven.isPresent()) ? minEven.get() : minEven.orElseThrow(()
                -> new RuntimeException(EXCEPTION_NOTIFICATION + numbers));
    }

    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     *
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        OptionalDouble average = IntStream.range(ZERO, numbers.size())
                .map(index -> index % TWO != ZERO ? numbers.get(index) - 1 : numbers.get(index))
                .filter(number -> number % TWO != ZERO)
                .mapToDouble(d -> d)
                .average();
        return (average.isPresent()) ? average.getAsDouble()
                : average.orElseThrow(() -> new NoSuchElementException("Not valid data input"));
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
        List<Person> sortedMens = peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge && p.getAge() <= toAge)
                .collect(Collectors.toList());
        return sortedMens;
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

     * }
     */
    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        List<Person> workingPeople = peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= maleToAge
                        || person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= fromAge && person.getAge() <= femaleToAge)
                .collect(Collectors.toList());
        return workingPeople;
    }

    /**
     * Given a List of `Person` instances (having `name`, `age`, `sex` and `cats` fields,
     * and each `Cat` having a `name` and `age`),
     * return the names of all cats whose owners are women from `femaleAge` years old inclusively.
     */
    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        List<String> catNames = peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN
                        && p.getAge() >= femaleAge && p.getCats().size() > 0)
                .map(p -> p.getCats())
                .flatMap(l -> l.stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
        return catNames;
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
        List<String> validCandidatesNames = candidates.stream()
                .filter(c -> new CandidateValidator().test(c))
                .map(c -> c.getName())
                .sorted()
                .collect(Collectors.toList());
        return validCandidatesNames;
    }
}
