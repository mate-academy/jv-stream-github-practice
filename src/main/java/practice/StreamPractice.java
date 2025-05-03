package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String NONE_MATCHES_MESSAGE = "Can't get min value from list: ";
    private static final String NUMBERS_SEPARATOR_SYMBOL = ",";
    private static final int HALF_DIVISER = 2;
    private static final int REMINDER_DEFAULT = 0;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(stringNumber ->
                        Arrays.stream(stringNumber.split(NUMBERS_SEPARATOR_SYMBOL)))
                .mapToInt(Integer::parseInt)
                .filter(numericValue -> numericValue % HALF_DIVISER == REMINDER_DEFAULT)
                .min()
                .orElseThrow(() ->
                        new RuntimeException(NONE_MATCHES_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        Function<Integer, Integer> oddSubstractFunction = integer -> {
            int index = numbers.indexOf(integer);
            int num = index % HALF_DIVISER != REMINDER_DEFAULT ? --integer : integer;
            numbers.set(index, null);
            return num;
        };
        return numbers.stream()
                .map(oddSubstractFunction)
                .filter(n -> n % HALF_DIVISER != REMINDER_DEFAULT)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex().equals(Person.Sex.MAN)
                        && fromAge <= person.getAge()
                        && toAge >= person.getAge())
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> workableFilter = person -> fromAge <= person.getAge()
                && ((person.getSex().equals(Person.Sex.WOMAN) && femaleToAge >= person.getAge())
                || (person.getSex().equals(Person.Sex.MAN) && maleToAge >= person.getAge()));
        return peopleList.stream()
                .filter(workableFilter)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex().equals(Person.Sex.WOMAN)
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream().map(Cat::getName))
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidate -> new CandidateValidator().test(candidate))
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
