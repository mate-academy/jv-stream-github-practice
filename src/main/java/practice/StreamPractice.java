package practice;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.People;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Stream.of(string.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min "
                        + "value from list:" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                    .map(index -> index % 2 == 0 ? numbers.get(index) : numbers.get(index) - 1)
                    .filter(n -> n % 2 == 1)
                    .average()
                    .getAsDouble();
    }

    public List<People> selectMenByAge(List<People> peopleList, int fromAge, int toAge) {
        Predicate<People> peoplePredicate = person -> person.getSex().equals(People.Sex.MAN)
                && person.getAge() >= fromAge && person.getAge() <= toAge;
        return peopleList.stream()
                .filter(peoplePredicate)
                .collect(Collectors.toList());
    }

    public List<People> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge,
                                          List<People> peopleList) {
        Predicate<People> peoplePredicate = person -> person.getAge() >= fromAge
                && person.getAge() <= (person.getSex()
                == People.Sex.MAN ? maleToAge : femaleToAge);
        return peopleList.stream()
                .filter(peoplePredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<People> peopleList, int femaleAge) {
        Predicate<People> peoplePredicate = person -> person.getSex().equals(People.Sex.WOMEN)
                && person.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(peoplePredicate)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public static List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
