package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(n -> n.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .sorted()
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(n -> numbers.indexOf(n) % 2 != 0 ? n - 1 : n)
                .filter(n -> n % 2 != 0)
                .distinct()
                .average()
                .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge
                        && p.getSex() == Person.Sex.MAN
                        && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        Predicate<Person> validPerson = person -> person.getAge() >= fromAge
                && ((person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge)
                || (person.getSex() == Person.Sex.WOMAN && person.getAge() <= femaleToAge));

        return peopleList.stream()
                .filter(validPerson)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= femaleAge
                        && p.getSex() == Person.Sex.WOMAN
                        && p.getCats().size() != 0)
                .map(Person::getCats)
                .flatMap(Collection::stream)
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
}
