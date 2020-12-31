package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {
    /**
     * Given list of strings where each element contains 1+ numbers:
     * input = {"5,30,100", "0, 22, 7", ...}
     * return min integer value. One more thing - we're interested in even numbers.
     * If there is no needed data throw RuntimeException with message
     * "Can't get min value from list: method_input_list"
     */
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(n -> Arrays.stream(n.split(",")))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(v -> v % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    /**
     * Given a List of Integer numbers,
     * subtract 1 from each element on an odd position (having the odd index).
     * Then return the average of all odd numbers or throw NoSuchElementException.
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> (i % 2 != 0) ? numbers.get(i) - 1 : numbers.get(i))
                .filter(i -> i % 2 != 0)
                .average()
                .getAsDouble();
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
                .filter(p -> p.getAge() >= fromAge
                        && p.getAge() <= toAge
                        && p.getSex() == People.Sex.MAN)
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
        return peopleList.stream()
                .filter(w -> w.getAge() >= fromAge
                        && (w.getSex() == People.Sex.WOMEN && w.getAge() <= femaleToAge
                        || w.getSex() == People.Sex.MAN && w.getAge() <= maleToAge))
                .collect(Collectors.toList());
    }

    /**
     * Given a List of `People` instances (having `name`, `age`, `sex` and `List of cats` fields,
     * and each `Cat` having a `name` and `age`),
     * return the names of all cats whose owners are women from `femaleAge` years old inclusively.
     */
    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(w -> w.getSex() == People.Sex.WOMEN
                        && w.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    /**
     * Your help with a election is needed. Given list of candidates, where each element
     * has Candidate.class type.
     * Check which candidates are eligible to apply for president position and return their
     * names sorted alphabetically.
     * The requirements are: person should be older than 35 y, should be allowed to vote,
     * have nationality - 'Ukrainian'
     * and live in urk for 10 years. For the last requirement use field periodsInUkr,
     * which has following view:
     * "2002-2015" For now we don't care if that was last 10 or not. We want to reuse our
     * validation in future, so
     * let's write our own impl of Predicate parametrized with Candidate in CandidateValidator.
     */
    public static List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
