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

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(w -> w.split(","))
                .flatMap(l -> Arrays.stream(l.clone()))
                .mapToInt(Integer::parseInt)
                .filter(value -> value % 2 == 0)
                .min()
                .orElseThrow(
                        () -> new RuntimeException("Can't get min value from list:"
                                + numbers.toString()));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> {
                    if (index % 2 != 0) {
                        return numbers.get(index) - 1;
                    }
                    return numbers.get(index);
                })
                .filter(value -> value % 2 != 0)
                .average()
                .orElseThrow(
                        () -> new NoSuchElementException("No such element")
                );
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(human -> human.getAge() >= fromAge
                        && human.getAge() <= toAge && human.getSex() == People.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<People> peopleList) {
        return peopleList.stream()
                .filter(human -> human.getAge() >= fromAge
                        && ((human.getSex() == People.Sex.MAN && human.getAge() <= maleToAge)
                        || (human.getSex() == People.Sex.WOMEN && human.getAge() <= femaleToAge)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(human -> human.getSex() == People.Sex.WOMEN
                        && human.getAge() >= femaleAge)
                .map(People::getCats)
                .flatMap(Collection::stream)
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
     * which has following view: "2002-2015"
     * We want to reuse our validation in future, so let's write our own impl of Predicate
     * parametrized with Candidate in CandidateValidator.
     */
    public static List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

}
