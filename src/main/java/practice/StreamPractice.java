package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String NUMBERS_SEPARATOR = ",";
    private static final CandidateValidator candidateValidator = new CandidateValidator();

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(e -> Arrays.stream(e.split(NUMBERS_SEPARATOR)))
                .filter(e -> isEven(Integer.parseInt(e)))
                .mapToInt(Integer::parseInt)
                .min()
                .orElseThrow(()
                        -> new RuntimeException("Can't get min value from list:" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> isEven(i) ? numbers.get(i) : numbers.get(i) - 1)
                .filter(e -> !isEven(e))
                .mapToDouble(value -> value)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Can't get value from list: "));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && (p.getAge() >= fromAge && p.getAge() <= toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> getWorkablePerson(person,fromAge,femaleToAge,maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> getCatOwner(person,femaleAge,person.getCats()))
                .map(Person::getCats)
                .flatMap(List::stream)
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private boolean getWorkablePerson(Person person, int fromAge,
                                      int femaleToAge, int maleToAge) {
        int toAge = person.getSex() == Person.Sex.WOMAN
                ? femaleToAge : maleToAge;
        int age = person.getAge();
        return age >= fromAge && age <= toAge;
    }

    private boolean getCatOwner(Person person,int age,List<Cat> catList) {
        return person.getAge() >= age && !catList.isEmpty() && person.getSex() == Person.Sex.WOMAN;
    }
}
