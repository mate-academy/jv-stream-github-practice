package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        List<Integer> evenNumbers = numbers.stream()
                .flatMap(s -> {
                    String[] numberStrings = s.split(",");
                    List<Integer> integers = new ArrayList<>();
                    for (String numberString : numberStrings) {
                        int number = Integer.parseInt(numberString);
                        if (number % 2 == 0) {
                            integers.add(number);
                        }
                    }
                    return integers.stream();
                })
                .sorted()
                .collect(Collectors.toList());

        if (evenNumbers.isEmpty()) {
            throw new RuntimeException("Can't get min value from list: " + numbers);
        }

        return evenNumbers.get(0);
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToDouble(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(num -> num % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge,
                                          List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> {
                    int age = person.getAge();
                    if (person.getSex() == Person.Sex.MAN) {
                        return age >= fromAge && age <= maleToAge;
                    } else if (person.getSex() == Person.Sex.WOMAN) {
                        return age >= fromAge && age <= femaleToAge;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex()
                        == Person.Sex.WOMAN && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidate ->
                        candidate.getAge() >= 35
                                && candidate.isAllowedToVote()
                                && candidate.getNationality().equals("Ukrainian")
                                && isPeriodInUkraineLongerThanTenYears(candidate.getPeriodsInUkr())
                )
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean isPeriodInUkraineLongerThanTenYears(String periodsInUkr) {
        if (periodsInUkr.matches("\\d{4}-\\d{4}")) {
            String[] years = periodsInUkr.split("-");
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            int yearDifference = endYear - startYear;

            return yearDifference >= 10;
        } else {
            return false;
        }
    }
}
