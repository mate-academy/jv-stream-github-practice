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
                      .map(n -> n.split(","))
                      .flatMap(Arrays::stream)
                      .map(Integer::parseInt)
                      .filter(n -> n % 2 == 0)
                      .min(Integer::compare)
                      .orElseThrow(() -> new RuntimeException(
                              "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                        .map(n -> n % 2 == 1 ? numbers.get(n) - 1 : numbers.get(n))
                        .filter(n -> n % 2 == 1)
                        .average()
                        .getAsDouble();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                         .filter(n -> n.getSex() == Person.Sex.MAN
                                  && (n.getAge() >= fromAge && n.getAge() <= toAge))
                         .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                         .filter(n -> n.getAge() >= fromAge
                                 && (n.getSex() == Person.Sex.WOMAN && n.getAge() <= femaleToAge
                                 || n.getSex() == Person.Sex.MAN && n.getAge() <= maleToAge))
                         .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                         .filter(n -> n.getSex() == Person.Sex.WOMAN
                                 && n.getAge() >= femaleAge)
                         .flatMap(n -> n.getCats().stream())
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
