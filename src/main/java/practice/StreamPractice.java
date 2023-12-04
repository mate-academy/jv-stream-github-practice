package practice;

import model.Candidate;
import model.Cat;
import model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMapToInt(s -> {
                    String[] split = s.split(",");
                    int[] ints = new int[split.length];
                    for (int i = 0; i < split.length; i++) {
                        ints[i] = Integer.parseInt(split[i].trim());
                    }
                    return java.util.Arrays.stream(ints);
                })
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: method_input_list"));
    }
    /**
     * Given a List of Integer numbers,
     * return the average of all odd numbers from the list or throw NoSuchElementException.
     * But before that subtract 1 from each element on an odd position (having the odd index).
     */
    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                .filter(i -> i % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }


    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN)
                .filter(person -> person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge &&
                        ((person.getSex() == Person.Sex.WOMAN && person.getAge() <= femaleToAge) ||
                                (person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream().map(Cat::getName))
                .collect(Collectors.toList());
    }
    /**
     * Your help with an election is needed. Given a list of candidates, where each element
     * has Candidate.class type.
     * Check which candidates are eligible to apply for the president position and return their
     * names sorted alphabetically.
     * The requirements are: a person should be older than 35 years, should be allowed to vote,
     * have nationality - 'Ukrainian'
     * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
     * which has the following view: "2002-2015"
     * We want to reuse our validation in the future, so let's write our implementation of Predicate
     * parametrized with Candidate in CandidateValidator.
     */
//    "Your CandidateValidator should "
//            + "implement functional interface Predicate, "
//            + "so it can be easily reused in the code",
    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(CandidateValidator::validate)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());


    }
}
