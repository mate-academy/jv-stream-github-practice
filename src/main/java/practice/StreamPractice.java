package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    private static final String ERR_MESSAGE = "Can't get min value from list: ";
    private static int CURRENT_INDEX;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(str -> Arrays.stream(str.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(n -> (n % 2) == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(ERR_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        CURRENT_INDEX = 0;
        return numbers.stream()
                .mapToInt(n -> (current_index(numbers.size()) % 2 == 0) ? n - 1 : n)
                .filter(n -> n % 2 == 1)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge
                        && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> {
                    int age = person.getAge();
                    boolean isMale = person.getSex() == Person.Sex.MAN;
                    return (isMale && age >= fromAge && age <= maleToAge)
                            || (!isMale && age >= fromAge && age <= femaleToAge);
                })
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private int current_index(int size) {
        if (CURRENT_INDEX < size) {
            CURRENT_INDEX++;
        }
        return CURRENT_INDEX;
    }
}
