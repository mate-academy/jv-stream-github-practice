package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {
    public static final String RUNTIME_EXCEPTION_MESSAGE = "Can't get min value from list: ";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream().flatMap(num -> {
            String[] numString = num.split(",");
            return Arrays.stream(numString)
                    .map(Integer::parseInt)
                    .filter(n -> n % 2 == 0);
        }).min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException(RUNTIME_EXCEPTION_MESSAGE
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0,numbers.size())
                .mapToObj(index -> index % 2 != 0 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(num -> num % 2 != 0)
                .mapToInt(n -> n)
                .average()
                .orElseThrow(NoSuchElementException::new);

    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(person -> person.getSex() == Person.Sex.MAN
                        && person.getAge() > fromAge && person.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList
                .stream()
                .filter(pepl -> pepl.getSex() == Person.Sex.MAN
                                ? pepl.getAge() >= fromAge
                        && pepl.getAge() <= maleToAge
                        : pepl.getAge() >= fromAge
                        && pepl.getAge() <= femaleToAge
                ).collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(person -> person.getAge() >= femaleAge
                        && person.getSex() == Person.Sex.WOMAN)
                .flatMap(pepl -> pepl.getCats()
                        .stream()
                        .map(cat -> cat.getName()))
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates
                .stream()
                .filter(candidate -> candidateValidator.test(candidate))
                .map(candidate -> candidate.getName())
                .sorted()
                .collect(Collectors.toList());
    }
}
