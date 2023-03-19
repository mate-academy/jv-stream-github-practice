package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public static final String REGEX_INTEGERS = ",";

    public int findMinEvenNumber(List<String> numbers) {
        int min;
        try {
            min = numbers.stream()
                    .flatMapToInt(string -> Arrays.stream(string.split(REGEX_INTEGERS))
                            .mapToInt(Integer::parseInt))
                    .filter(i -> i % 2 == 0)
                    .min()
                    .getAsInt();
        } catch (Exception e) {
            throw new RuntimeException("Can't get min value from list: < Here is our input '"
                    + numbers + "' >");
        }
        return min;
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        Double average;
        final Integer[] index = {0};
        Function<Integer, Integer> incOnOddIndex = integer -> {
            integer = index[0] % 2 == 1 ? integer - 1 : integer;
            index[0]++;
            return integer;
        };
        try {
            average = numbers.stream()
                    .map(incOnOddIndex)
                    .filter(i -> i % 2 == 1)
                    .mapToInt(Integer::valueOf)
                    .average()
                    .getAsDouble();
        } catch (Exception e) {
            throw new NoSuchElementException("Error empty List of numbers");
        }
        return average;
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> fromAgeToAge = person -> person.getSex().equals(Person.Sex.MAN)
                && fromAge <= person.getAge()
                && person.getAge() <= toAge;
        return peopleList.stream()
                .filter(fromAgeToAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> fromAgeToSpecificSexAge = person -> {
            int age = person.getAge();
            Person.Sex sex = person.getSex();
            return fromAge <= age
                    && (sex.equals(Person.Sex.MAN) && age <= maleToAge
                    || sex.equals(Person.Sex.WOMAN) && age <= femaleToAge);
        };
        return peopleList.stream()
                .filter(fromAgeToSpecificSexAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> womenFromAge = person -> person.getSex().equals(Person.Sex.WOMAN)
                && person.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(womenFromAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
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
}
