package practice;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        if (numbers.isEmpty()) {
            throw new RuntimeException("Can't get min value from list");
        }
        List<List<String>> lists = numbers.stream()
                .map(x -> Arrays.stream(x.split(",")).toList()).toList();
        List<String> strings = lists.stream().flatMap(List::stream).toList();
        return strings.stream()
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .min()
                .orElseThrow(RuntimeException::new);

    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        int sumOfOddNumbers = 0;
        int countOfOddNumbers = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if (i % 2 == 1) {
                num -= 1;
            }
            if (num % 2 != 0) {
                sumOfOddNumbers += num;
                countOfOddNumbers++;
            }
        }
        if (countOfOddNumbers == 0) {
            throw new NoSuchElementException("No odd numbers in the list");
        }
        return (double) sumOfOddNumbers / countOfOddNumbers;
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        List<Person> selectedMen = new ArrayList<>();

        for (Person person : peopleList) {
            if (person.getSex() == Person.Sex.MAN
                    && person.getAge() >= fromAge
                    && person.getAge() <= toAge) {
                selectedMen.add(person);
            }
        }
        return selectedMen;
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
        List<String> catNames = new ArrayList<>();

        for (Person person : peopleList) {
            if (person.getSex() == Person.Sex.WOMAN && person.getAge() >= femaleAge) {
                for (Cat cat : person.getCats()) {
                    catNames.add(cat.getName());
                }
            }
        }
        return catNames;
    }

    public List<String> validateCandidates(List<Candidate> candidates) {

        return candidates.stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .toList();
    }
}
