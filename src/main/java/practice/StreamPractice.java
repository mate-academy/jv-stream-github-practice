package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::valueOf)
                .filter(i -> i % 2 == 0)
                .min()
                .stream().findAny()
                .orElseThrow(() ->
                        new RuntimeException("Can't get min value from list: method_input_list"));

    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        List<Integer> correctIntegers = IntStream.range(0, numbers.size())
                .boxed()
                .collect(Collectors.toMap(i -> i, numbers::get))
                .entrySet()
                .stream()
                .map(m -> {
                    if (m.getKey() % 2 == 1) {
                        m.setValue(m.getValue() - 1);
                    }
                    return m;
                })
                .map(Map.Entry::getValue)
                .filter(i -> i % 2 == 1)
                .collect(Collectors.toList());
        if (correctIntegers.size() == 0) {
            throw new NoSuchElementException();
        }
        int sum = correctIntegers.stream()
                .mapToInt(i -> i)
                .sum();
        return sum / (double) correctIntegers.size();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Person.Sex.MAN
                        && p.getAge() >= fromAge
                        && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge)
                .filter(p -> p.getSex() == Person.Sex.MAN && p.getAge() <= maleToAge
                        || p.getSex() == Person.Sex.WOMAN && p.getAge() <= femaleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= femaleAge && p.getSex() == Person.Sex.WOMAN)
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
