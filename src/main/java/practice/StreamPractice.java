package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private final CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMapToInt((p) -> Arrays.stream(p.split(","))
                        .mapToInt(Integer::parseInt))
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(index -> index % 2 == 1)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> menInSuitableAgePredicate = p -> p.getSex() == Person.Sex.MAN
                && p.getAge() >= fromAge
                && p.getAge() <= toAge;
        return peopleList.stream()
                .filter(menInSuitableAgePredicate)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> peopleInSuitableAgePredicate = p -> p.getAge() >= fromAge
                && (p.getSex() == Person.Sex.MAN
                ? p.getAge() <= maleToAge
                : p.getAge() <= femaleToAge);
        return peopleList.stream()
                .filter(peopleInSuitableAgePredicate)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> womenInSuitableAgePredicate = p -> p.getSex() == Person.Sex.WOMAN
                && p.getAge() >= femaleAge;
        return peopleList.stream()
                .filter(womenInSuitableAgePredicate)
                .flatMap(p -> p.getCats()
                        .stream()
                        .map(Cat::getName))
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
