package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(string ->
                        Arrays.stream(string.split(","))
                                .mapToInt(Integer::valueOf))
                .flatMapToInt(IntStream::distinct)
                .filter(number -> number % 2 == 0)
                .sorted()
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: <" + numbers + ">"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream
                .range(0, numbers.size())
                .map(index -> index % 2 == 0 ? numbers.get(index) : numbers.get(index) - 1)
                .filter(number -> number % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> maleSelector = person -> person.getSex() == Person.Sex.MAN
                    && person.getAge() >= fromAge && person.getAge() <= toAge;
        return peopleList
                .stream()
                .filter(maleSelector)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> workablePeopleSelector = human -> human.getAge() >= fromAge
                && ((human.getSex() == Person.Sex.MAN && human.getAge() <= maleToAge)
                || (human.getSex() == Person.Sex.WOMAN && human.getAge() <= femaleToAge));
        return peopleList
                .stream()
                .filter(workablePeopleSelector)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> femaleSelector = human -> human.getSex() == Person.Sex.WOMAN
                                                && human.getAge() >= femaleAge;
        return peopleList
                .stream()
                .filter(femaleSelector)
                .map(human -> human.getCats().stream())
                .flatMap(Stream::distinct)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        Predicate<Candidate> candidateValidator = new CandidateValidator();
        return candidates
                .stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
