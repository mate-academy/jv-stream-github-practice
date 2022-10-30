package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {
    private static final String SPLITTER_FOR_FIND_MIN_EVEN_NUMBER = ",";

    private Predicate<Integer> evenNumber = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer % 2 == 0;
        }
    };

    public int findMinEvenNumber(List<String> numbers) {
        try {
            return numbers.stream()
                    .map(m -> m.split(SPLITTER_FOR_FIND_MIN_EVEN_NUMBER))
                    .flatMap(Arrays::stream)
                    .map(Integer::parseInt)
                    .filter(evenNumber)
                    .mapToInt(m -> m)
                    .min()
                    .getAsInt();
        } catch (RuntimeException e) {
            throw new RuntimeException("Can't get min value from list");
        }
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(o -> o % 2 == 0 ? numbers.get(o) : numbers.get(o) - 1)
                .filter(o -> o % 2 != 0)
                .average()
                .orElseThrow();

    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(m -> m.getSex() == Person.Sex.MAN)
                .filter(m -> m.getAge() > fromAge)
                .filter(m -> m.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(m -> m.getAge() >= fromAge)
                .filter(m -> m.getSex().equals(Person.Sex.WOMAN)
                        ? m.getAge() <= femaleToAge : m.getAge() <= maleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(m -> m.getSex().equals(Person.Sex.WOMAN))
                .filter(m -> m.getAge() >= femaleAge)
                .flatMap(m -> m.getCats().stream())
                .map(m -> m.getName())
                .collect(Collectors.toList());
    }

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates
                .stream()
                .filter(new CandidateValidator())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
