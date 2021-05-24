package practice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {
    /**
     * Given list of strings where each element contains 1+ numbers:
     * input = {"5,30,100", "0,22,7", ...}
     * return min integer value. One more thing - we're interested in even numbers.
     * If there is no needed data throw RuntimeException with message
     * "Can't get min value from list: < Here is our input 'numbers' >"
     */
    public int findMinEvenNumber(List<String> numbers) {
        try {
            return Stream.of(numbers)
                    .flatMap(Collection::stream)
                    .flatMap(str -> Arrays.stream(str.split(",")))
                    .filter(num -> Integer.parseInt(num) % 2 == 0)
                    .mapToInt(Integer::parseInt).sorted().findFirst().getAsInt();
        } catch (RuntimeException e) {
            throw new RuntimeException( "Can't get min value from list: method_input_list");
        }
    }

    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        OptionalDouble average = IntStream.range(0, numbers.size())
                .map(i -> i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i))
                .peek(System.out::println)
                .filter(num -> num % 2 != 0).average();
        return average.getAsDouble();
    }
    /**
     * Given a List of `People` instances (having `name`, `age` and `sex` fields),
     * for example, `Arrays.asList( new People(«Victor», 16, Sex.MAN),
     * new People(«Helen», 42, Sex.WOMEN))`,
     * select from the List only men whose age is from `fromAge` to `toAge` inclusively.
     * <p>
     * Example: select men who can be recruited to army (from 18 to 27 years old inclusively).
     */
    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(people -> people.getSex().equals(People.Sex.MAN)
                        && people.getAge() > fromAge && people.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    /**
     * Given a List of `People` instances (having `name`, `age` and `sex` fields),
     * for example, `Arrays.asList( new People(«Victor», 16, Sex.MAN),
     * new People(«Helen», 42, Sex.WOMEN))`,
     * select from the List only people whose age is from `fromAge` and to `maleToAge` (for men)
     * or to `femaleToAge` (for women) inclusively.
     * <p>
     * Example: select people of working age
     * (from 18 y.o. and to 60 y.o. for men and to 55 y.o. for women inclusively).
     */
    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        return peopleList.stream().filter(people -> people.getAge() >= fromAge)
                .filter(people -> people.getSex().equals(People.Sex.MAN)
                        && people.getAge() <= maleToAge || (people.getSex().equals(People.Sex.WOMEN)
                        && people.getAge() <= femaleToAge)).collect(Collectors.toList());
    }

    /**
     * Given a List of `People` instances (having `name`, `age`, `sex` and `List of cats` fields,
     * and each `Cat` having a `name` and `age`),
     * return the names of all cats whose owners are women from `femaleAge` years old inclusively.
     */
    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(people -> people.getSex().equals(People.Sex.WOMEN))
                .filter(people -> people.getAge() > femaleAge)
                .map(People::getCats).flatMap(l -> l.stream())
                .map(cat -> cat.getName()).collect(Collectors.toList());
    }

    /**
     * Your help with a election is needed. Given list of candidates, where each element
     * has Candidate.class type.
     * Check which candidates are eligible to apply for president position and return their
     * names sorted alphabetically.
     * The requirements are: person should be older than 35 y, should be allowed to vote,
     * have nationality - 'Ukrainian'
     * and live in urk for 10 years. For the last requirement use field periodsInUkr,
     * which has following view: "2002-2015"
     * We want to reuse our validation in future, so let's write our own impl of Predicate
     * parametrized with Candidate in CandidateValidator.
     */
    public List<String> validateCandidates(List<Candidate> candidates) {
        candidates.forEach(candidate -> {
            String[] split = candidate.getPeriodsInUkr().split("-");
            candidate.setPeriodsInUkr(String.valueOf(Integer.parseInt(split[1]) - Integer.parseInt(split[0])));
        });
        return candidates.stream()
                .filter(candidate -> candidate.getNationality().equals("Ukrainian")
                        && candidate.getAge() >= 35
                        && candidate.isAllowedToVote())
                .filter(candidate -> Integer.parseInt(candidate.getPeriodsInUkr()) > 10)
                .map(candidate -> candidate.getName())
                .sorted()
                .collect(Collectors.toList());
    }
}
