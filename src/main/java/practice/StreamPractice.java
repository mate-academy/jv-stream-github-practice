package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String REGEX = ",";
    private static final String MESSAGE = "Can't get min value from list: ";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(n -> Arrays.stream(n.split(REGEX)))
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException(MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> numbers.indexOf(n) % 2 != 0 ? n - 1 : n)
                .filter(n -> n % 2 != 0)
                .mapToInt(n -> n)
                .distinct()
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN && p.getAge() >= fromAge
                        && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> customPredicate = person -> person.getSex() == Person.Sex.WOMAN
                ? person.getAge() >= fromAge && person.getAge() <= femaleToAge
                : person.getAge() >= fromAge && person.getAge() <= maleToAge;
        return peopleList.stream()
                .filter(customPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN && p.getAge() >= femaleAge
                        && p.getCats().size() != 0)
                .map(Person::getCats)
                .flatMap(l -> l.stream()
                    .map(Cat::getName)
                )
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
