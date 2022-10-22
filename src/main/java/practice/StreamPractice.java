package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        try {
            return numbers.stream()
                    .map(e -> e.split(","))
                    .flatMap(Arrays::stream)
                    .mapToInt(Integer::parseInt)
                    .filter(i -> (i & 1) == 0)
                    .min()
                    .orElseThrow(RuntimeException::new);
        } catch (RuntimeException e) {
            throw new RuntimeException("Can't get min value from list " + numbers);
        }
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Stream.iterate(1, i -> i < numbers.size(), i -> i + 2)
                .forEach(i -> copyNumbers.set(i, numbers.get(i) - 1));
        return copyNumbers.stream()
                .filter(n -> (n & 1) == 1)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> isMenPersonsBetweenAge(p, fromAge, toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> isPersonWorkable(p, fromAge, femaleToAge, maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                //.filter(new CustomPredicate())
                .filter(p -> p.getSex() == Person.Sex.WOMAN && p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean isMenPersonsBetweenAge(Person person, int fromAge, int toAge) {
        return person.getSex() == Person.Sex.MAN
                && person.getAge() >= fromAge
                && person.getAge() <= toAge;
    }

    private boolean isPersonWorkable(Person person, int fromAge, int femaleToAge, int maleToAge) {
        if (person.getAge() >= fromAge) {
            return person.getSex() == Person.Sex.MAN
                    ? person.getAge() <= maleToAge : person.getAge() <= femaleToAge;
        }
        return false;
    }
}
