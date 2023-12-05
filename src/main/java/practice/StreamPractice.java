package practice;

import model.Candidate;
import model.Cat;
import model.Person;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamPractice {

    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMapToInt(s -> {
                    String[] split = s.split(",");
                    int[] ints = new int[split.length];
                    for (int i = 0; i < split.length; i++) {
                        ints[i] = Integer.parseInt(split[i].trim());
                    }
                    return java.util.Arrays.stream(ints);
                })
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: method_input_list"));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i % 2 == 0 ? numbers.get(i) : numbers.get(i) - 1)
                .filter(i -> i % 2 != 0)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }


    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN)
                .filter(person -> person.getAge() >= fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge, int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= fromAge &&
                        ((person.getSex() == Person.Sex.WOMAN && person.getAge() <= femaleToAge) ||
                                (person.getSex() == Person.Sex.MAN && person.getAge() <= maleToAge)))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.WOMAN && person.getAge() >= femaleAge)
                .flatMap(person -> person.getCats().stream().map(Cat::getName))
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(new CandidateValidator())
                .filter(candidate ->
                        Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]) -
                                Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]) >= 10)
                .filter(candidate -> candidate.getAge() >= MIN_AGE)
                .filter(Candidate::isAllowedToVote)
                .filter(candidate -> NATIONALITY.equals(candidate.getNationality()))
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
