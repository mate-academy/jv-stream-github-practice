package practice;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        List<Integer> evenNumbers = numbers.stream()
                .flatMap(s -> Stream.of(s.split(",")))
                .map(Integer::valueOf)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        if (evenNumbers.isEmpty()) {
            throw new RuntimeException("Can't get min value from list: " + numbers);
        }

        return evenNumbers.stream()
                .min(Integer::compareTo)
                .orElseThrow();
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> modifiedNumbers = IntStream.range(0, numbers.size())
                .mapToObj(i -> (i % 2 == 1) ? numbers.get(i) - 1 : numbers.get(i))
                .collect(Collectors.toList());

        List<Integer> oddNumbers = modifiedNumbers.stream()
                .filter(num -> num % 2 == 1)
                .collect(Collectors.toList());

        if (oddNumbers.isEmpty()) {
            throw new NoSuchElementException("No odd numbers found");
        }

        return oddNumbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge && person.getAge() <= maleToAge
                        || person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= fromAge && person.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream().map(Cat::getName))
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        if (candidates == null || candidates.isEmpty()) {
            return Collections.emptyList();
        }

        return candidates.stream()
                .filter(CandidateValidator::isEligibleForPresident)
                .map(Candidate::getName)
                .sorted() // Sort the names alphabetically
                .collect(Collectors.toList());
    }

    static int calculateYearsInUkraine(String period) {
        String[] years = period.split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return endYear - startYear + 1;
    }
}
