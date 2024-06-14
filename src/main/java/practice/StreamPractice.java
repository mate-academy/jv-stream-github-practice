package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String NUMBERS_SEPARATOR = ",";

    /**
     * Given list of strings where each element contains 1+ numbers:
     * input = {"5,30,100", "0,22,7", ...}
     * return min integer value. One more thing - we're interested in even numbers.
     * If there is no needed data throw RuntimeException with message
     * "Can't get min value from list: < Here is our input 'numbers' >"
     */
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap((Function<String, Stream<String>>)
                        s -> Arrays.stream(s.split(NUMBERS_SEPARATOR)))
                .mapToInt(Integer::parseInt)
                .boxed()
                .min(getMinEvenComparator())
                .orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .boxed()
                .collect(Collectors.toMap(
                        k -> k,
                        numbers::get
                ))
                .entrySet()
                .stream()
                .mapToInt(getEntryToIntFunction())
                .filter(getOdd())
                .average()
                .orElseThrow(() -> new NoSuchElementException("Can't get avg value from list"));
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
                .filter(person -> isFitMan(fromAge, toAge, person))
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
                .filter(person ->
                        isFitMan(fromAge, maleToAge, person)
                                || isFitWoman(fromAge, femaleToAge, person)
                )
                .toList();
    }

    /**
     * Given a List of `Person` instances (having `name`, `age`, `sex` and `cats` fields,
     * and each `Cat` having a `name` and `age`),
     * return the names of all cats whose owners are women from `femaleAge` years old inclusively.
     */
    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN)
                .filter(person -> person.getAge() >= femaleAge)
                .flatMap((Function<Person, Stream<String>>)
                        person -> person.getCats().stream()
                                .map(Cat::getName))
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

    private static Comparator<Integer> getMinEvenComparator() {
        return (o1, o2) -> {
            if (o1 % 2 == 0 && o2 % 2 == 0) {
                return o1 - o2;
            }
            if (o1 % 2 == 0) {
                return -1;
            }
            return 1;
        };
    }

    private static ToIntFunction<Map.Entry<Integer, Integer>> getEntryToIntFunction() {
        return entry -> {
            if (entry.getKey() % 2 == 1) {
                return entry.getValue() - 1;
            }
            return entry.getValue();
        };
    }

    private static IntPredicate getOdd() {
        return e -> e % 2 == 1;
    }

    private static boolean isFitMan(int maleFromAge, int maleToAge, Person person) {
        return person.getSex() == Person.Sex.MAN
                && person.getAge() >= maleFromAge
                && person.getAge() <= maleToAge;
    }

    private static boolean isFitWoman(int femaleFromAge,int femaleToAge, Person person) {
        return person.getSex() == Person.Sex.WOMAN
                && person.getAge() >= femaleFromAge
                && person.getAge() <= femaleToAge;
    }
}
