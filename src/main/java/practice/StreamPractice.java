package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) throws RuntimeException {
        return numbers.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(integer -> integer % 2 == 0)
                .min()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(value -> value % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(people -> people.getSex() == Person.Sex.MAN
                        && people.getAge() >= fromAge && people.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> predicateForPeople = people -> (people.getSex() == Person.Sex.MAN
                && people.getAge() >= fromAge && people.getAge() <= maleToAge)
                || (people.getSex() == Person.Sex.WOMAN
                && people.getAge() >= fromAge && people.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(predicateForPeople)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter((people -> people.getSex()
                         == Person.Sex.WOMAN && people.getAge() >= femaleAge
                        && !people.getCats().isEmpty()))
                .flatMap(person -> person.getCats()
                        .stream()
                        .map(Cat::getName))
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator::test)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
