package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String SEPARATOR = ",";
    private static final String ERROR_MSG = "Can't get min value from list: ";
    private final IntPredicate isEven = value -> (value & 1) == 0;

    /**
     * Given list of strings where each element contains 1+ numbers:
     * input = {"5,30,100", "0,22,7", ...}
     * return min integer value. One more thing - we're interested in even numbers.
     * If there is no needed data throw RuntimeException with message
     * "Can't get min value from list: < Here is our input 'numbers' >"
     */
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> Arrays.stream(s.split(SEPARATOR)))
                .mapToInt(Integer::valueOf)
                .filter(isEven)
                .min()
                .orElseThrow(() -> new RuntimeException(ERROR_MSG + numbers));
    }

    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        IntPredicate isOdd = isEven.negate();
        return IntStream.range(0, numbers.size())
                .map(i -> isOdd.test(i) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(isOdd)
                .average()
                .getAsDouble();
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
        Predicate<Person> isMaleRightAge =
                getPersonSexAndAgePredicate(Person.Sex.MAN, fromAge, toAge);
        return peopleList.stream()
                .filter(isMaleRightAge)
                .collect(Collectors.toList());
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
        Predicate<Person> isMaleRightAge =
                getPersonSexAndAgePredicate(Person.Sex.MAN, fromAge, maleToAge);
        Predicate<Person> isFemaleRightAge =
                getPersonSexAndAgePredicate(Person.Sex.WOMAN, fromAge, femaleToAge);
        return peopleList.stream()
                .filter(isMaleRightAge.or(isFemaleRightAge))
                .collect(Collectors.toList());
    }

    /**
     * Given a List of `Person` instances (having `name`, `age`, `sex` and `cats` fields,
     * and each `Cat` having a `name` and `age`),
     * return the names of all cats whose owners are women from `femaleAge` years old inclusively.
     */
    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> isFemaleOverAge =
                getPersonSexAndAgePredicate(Person.Sex.WOMAN, femaleAge, Integer.MAX_VALUE);
        return peopleList.stream()
                .filter(isFemaleOverAge)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
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
                .collect(Collectors.toList());
    }

    private Predicate<Person> getPersonSexAndAgePredicate(Person.Sex sex, int fromAge, int toAge) {
        return person -> person.getSex() == sex
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }
}
