package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
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
        return numbers.stream()
                .flatMap(nums -> Arrays.stream(nums.split(",")))
                .mapToInt(transition -> Integer.parseInt(String.valueOf(transition)))
                .filter(parity -> parity % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));

    }

    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        int count = (int) IntStream.range(0, numbers.size())
                .mapToObj(number -> {
                    if (number % 2 != 0) {
                        return numbers.get(number) - 1;
                    } else {
                        return numbers.get(number);
                    }
                })
                .filter(odd -> odd % 2 != 0)
                .count();
        int sum = IntStream.range(0, numbers.size())
                .mapToObj(number -> {
                    if (number % 2 != 0) {
                        return numbers.get(number) - 1;
                    } else {
                        return numbers.get(number);
                    }
                })
                .filter(odd -> odd % 2 != 0)
                .reduce(Integer::sum)
                .get();
        if (count == 0) {
            throw new NoSuchElementException("No such odd element");
        }
        return (double) sum / (double) count;
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
                .filter(people -> people.getAge() >= fromAge && people.getAge() <= toAge
                        && people.getSex().equals(Person.Sex.MAN))
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
        return peopleList.stream()
                .filter(person -> testForWorkable(person,fromAge,femaleToAge,maleToAge))
                .collect(Collectors.toList());
    }

    /**
     * Given a List of `Person` instances (having `name`, `age`, `sex` and `cats` fields,
     * and each `Cat` having a `name` and `age`),
     * return the names of all cats whose owners are women from `femaleAge` years old inclusively.
     */
    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex().equals(Person.Sex.WOMAN)
                        && person.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(cats -> cats.stream())
                .map(cat -> cat.getName())
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
        CandidateValidator validator = new CandidateValidator();
        return candidates.stream()
                .filter(candidate -> validator.test(candidate))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean testForWorkable(Person person, int fromAge, int femaleToAge,
                         int maleToAge) {
        return ((person.getSex().equals(Person.Sex.MAN) && person.getAge() >= fromAge
                && person.getAge() <= maleToAge)
                || (person.getSex().equals(Person.Sex.WOMAN) && person.getAge() >= fromAge
                && person.getAge() <= femaleToAge));
    }
}
