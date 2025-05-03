package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String REGEX_COMMA = ",";
    private static final String NO_SUCH_DATA_MESSAGE = "Can't get min value from list: ";
    private CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(string -> string.split(REGEX_COMMA))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::valueOf)
                .filter(this::isEven)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        NO_SUCH_DATA_MESSAGE + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> (!isEven(index)) ? numbers.get(index) - 1 : numbers.get(index))
                .filter(number -> !isEven(number))
                .mapToDouble(Double::valueOf)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> filterMenByAge = person -> {
            int age = person.getAge();
            return Person.Sex.MAN.equals(person.getSex())
                    && age >= fromAge
                    && age <= toAge;
        };
        return peopleList.stream()
                .filter(filterMenByAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> filterWorkablePeople = person -> {
            int age = person.getAge();
            Person.Sex sex = person.getSex();
            return age >= fromAge
                    && (Person.Sex.WOMAN.equals(sex) && age <= femaleToAge
                    || Person.Sex.MAN.equals(sex) && age <= maleToAge);
        };
        return peopleList.stream()
                .filter(filterWorkablePeople)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> Person.Sex.WOMAN.equals(p.getSex())
                        && p.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
