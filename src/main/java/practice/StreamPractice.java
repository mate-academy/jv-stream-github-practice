package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final int NUMBER_SUBTRACTED = 1;

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(str -> Arrays.stream(str.split(",")).mapToInt(Integer::parseInt))
                .flatMap(IntStream::boxed)
                .filter(i -> i % 2 == 0)
                .min(Integer::compare)
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list:" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 != 0) {
                numbers.set(i, numbers.get(i) - NUMBER_SUBTRACTED);
            }
        }
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToDouble(Double::valueOf)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge
                        && p.getAge() <= toAge)
                .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge
                        && p.getAge() <= maleToAge
                        || p.getSex() == Person.Sex.WOMAN
                        && p.getAge() >= fromAge
                        && p.getAge() <= femaleToAge)
                .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.WOMAN && p.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(List::stream)
                .map(Cat::getName)
                .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
