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

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(integer -> integer % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: < Here is our input "
                                + numbers + " >"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(integer -> integer % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person != null
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge
                        && person.getSex().equals(Person.Sex.MAN))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicate = person -> person != null
                    && ((person.getSex().equals(Person.Sex.MAN)
                    && person.getAge() >= fromAge
                    && person.getAge() <= maleToAge)
                    || (person.getSex().equals(Person.Sex.WOMAN)
                    && person.getAge() >= fromAge
                    && person.getAge() <= femaleToAge));
        return peopleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person != null
                        && person.getSex().equals(Person.Sex.WOMAN)
                        && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        Predicate<Candidate> candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
