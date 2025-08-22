package practice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;
import model.Person.Sex;

public class StreamPractice {

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap(s -> java.util.Arrays.stream(s.split(",")))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException(
                        "Can't get min value from list: " + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 1 ? numbers.get(i) - 1 : numbers.get(i))
                .filter(n -> n % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .filter(p -> p.getAge() >= fromAge && p.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge,
                                          List<Person> peopleList) {
        return peopleList.stream()
                .filter(p -> p.getAge() >= fromAge)
                .filter(p -> (p.getSex() == Sex.MAN && p.getAge() <= maleToAge)
                        || (p.getSex() == Sex.WOMAN && p.getAge() <= femaleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(p -> p.getSex() == Sex.WOMAN)
                .filter(p -> p.getAge() >= femaleAge)
                .flatMap(p -> p.getCats().stream())
                .map(model.Cat::getName)
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(c -> c != null)
                .filter(c -> c.getAge() >= 35)
                .filter(c -> "Ukrainian".equals(c.getNationality()))
                .filter(Candidate::isAllowedToVote)
                .filter(c -> {
                    try {
                        String[] years = c.getPeriodsInUkr().split("-");
                        int start = Integer.parseInt(years[0].trim());
                        int end = Integer.parseInt(years[1].trim());
                        return (end - start) >= 10;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
