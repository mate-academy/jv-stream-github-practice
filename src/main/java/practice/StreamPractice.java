package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new RuntimeException("Can't get min value from list: " + numbers);
        }
        return Arrays.stream(String.join(",", numbers)
                        .split(","))
                .map(Integer::parseInt)
                .mapToInt(n -> n)
                .filter(n -> n % 2 == 0)
                .min()
                .getAsInt();
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return numbers.stream()
                    .map(n -> numbers.indexOf(n) % 2 == 1 ? n - 1 : n)
                    .filter(n -> n % 2 == 1)
                    .mapToDouble(n -> n)
                    .distinct()
                    .average()
                    .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(n -> n.getAge() >= fromAge
                        && n.getAge() <= toAge
                        && n.getSex() == Person.Sex.MAN)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(n -> n.getSex() == Person.Sex.MAN
                        && n.getAge() >= fromAge && n.getAge() <= maleToAge
                        || n.getSex() == Person.Sex.WOMAN && n.getAge() >= fromAge
                        && n.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(n -> n.getSex() == Person.Sex.WOMAN && n.getAge() >= femaleAge)
                .map(Person::getCats)
                .flatMap(Collection::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(n -> new CandidateValidator().test(n))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}

