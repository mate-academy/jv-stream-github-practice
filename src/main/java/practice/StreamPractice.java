package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice implements Predicate<Candidate> {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(i -> i.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> (i % 2 != 0 ? numbers.get(i) - 1 : numbers.get(i)))
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(() -> new NoSuchElementException(
                        "No one odd number was found in the list"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(i -> i.getSex() == Person.Sex.MAN)
                .filter(i -> i.getAge() >= fromAge && i.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(i -> i.getSex() == Person.Sex.MAN
                        && i.getAge() >= fromAge && i.getAge() <= maleToAge
                || i.getSex() == Person.Sex.WOMAN
                        && i.getAge() >= fromAge && i.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(i -> i.getSex() == Person.Sex.WOMAN
                && i.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        Predicate<Candidate> validator = new StreamPractice(); // No need to cast

        return candidates.stream()
                .filter(validator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        String periods = candidate.getPeriodsInUkr();
        if (periods == null || periods.isEmpty()) {
            return false;
        }

        String[] years = periods.split("-");
        if (years.length != 2) {
            return false;
        }

        int startYear;
        int endYear;

        try {
            startYear = Integer.parseInt(years[0]);
            endYear = Integer.parseInt(years[1]);
        } catch (NumberFormatException e) {
            return false;
        }

        int yearsInUkraine = endYear - startYear;

        return candidate.getAge() > 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && yearsInUkraine >= 10;
    }
}
