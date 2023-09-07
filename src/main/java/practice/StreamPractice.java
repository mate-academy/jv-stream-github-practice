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

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(x -> Arrays.stream(x.split(",")))
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i -> {
                    int num = numbers.get(i);
                    if (i % 2 == 1) {
                        num -= 1;
                    }
                    return num;
                })
                .filter(num -> num % 2 != 0)
                .mapToDouble(i -> i)
                .average()
                .orElseThrow(() -> new NoSuchElementException("No odd numbers in the list"));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() >= fromAge
                        && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> {
                    int age = person.getAge();
                    Person.Sex sex = person.getSex();
                    boolean isFemale = sex == Person.Sex.WOMAN;
                    boolean isMale = sex == Person.Sex.MAN;
                    return (isFemale && age >= fromAge && age <= femaleToAge)
                            || (isMale && age >= fromAge && age <= maleToAge);
                })
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person
                        .Sex.WOMAN && person
                        .getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream())
                .map(Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {

        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
