package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private final Predicate<Candidate> isAbleToRunForPresident = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
            .map(e -> e.split(","))
            .flatMap(Arrays::stream)
            .map(Integer::parseInt)
            .filter(e -> e % 2 == 0)
            .sorted()
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Can't get min value from list: " + numbers));
    }
    
    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
            .map(index -> {
                if (index % 2 != 0) {
                    return numbers.get(index) - 1;
                }
                return numbers.get(index);
            })
            .filter(number -> number % 2 != 0)
            .average()
            .orElseThrow(() -> new NoSuchElementException("Empty List provided"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
            .filter(person -> person.getAge() >= fromAge && person.getAge() <= toAge)
            .filter(person -> person.getSex().name().equals("MAN"))
            .toList();
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
            int maleToAge, List<Person> peopleList) {
        Predicate<Person> isWorkable = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                if (person.getSex().name().equals("MAN")) {
                    return person.getAge() >= fromAge && person.getAge() <= maleToAge;
                }
                return person.getAge() >= fromAge && person.getAge() <= femaleToAge;
            }
        };
        return peopleList.stream()
            .filter(isWorkable)
            .toList();
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> isNeededCatOwner = person -> person.getSex().name().equals("WOMAN")
                && person.getAge() >= femaleAge;
        return peopleList.stream()
            .filter(isNeededCatOwner)
            .flatMap(person -> person.getCats().stream())
            .map(Cat::getName)
            .toList();
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
            .filter(isAbleToRunForPresident)
            .map(Candidate::getName)
            .sorted()
            .toList();
    }
}
