package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(string -> Arrays.stream(string.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(integer -> integer % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream
                .range(0, numbers.size())
                .map(index -> index % 2 == 0 ? numbers.get(index) : numbers.get(index) - 1)
                .filter(t -> t % 2 != 0)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(t -> t.getAge() >= fromAge
                        && t.getAge() <= toAge
                        && t.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(
            int fromAge,
            int femaleToAge,
            int maleToAge, List<Person> peopleList) {

        return peopleList.stream()
                .filter(t -> t.getAge() >= fromAge
                        && (((t.getSex() == Person.Sex.MAN && t.getAge() <= maleToAge))
                        || (t.getSex() == Person.Sex.WOMAN && t.getAge() <= femaleToAge)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {

        return peopleList.stream()
                .filter(t -> t.getSex() == Person.Sex.WOMAN && t.getAge() >= femaleAge
                        && !t.getCats().isEmpty())
                .flatMap(t -> t.getCats().stream())
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
