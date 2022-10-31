package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Person;

public class StreamPractice {
    private static final String SPLITTER_FOR_FIND_MIN_EVEN_NUMBER = ",";

    private IntPredicate evenNumber = new IntPredicate() {
        @Override
        public boolean test(int value) {
            return value % 2 == 0;
        }
    };

    public int findMinEvenNumber(List<String> numbers) {
        return numbers
                .stream()
                .map(m -> m.split(SPLITTER_FOR_FIND_MIN_EVEN_NUMBER))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(evenNumber)
                .min()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't get min value from list" + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(o -> o % 2 == 0 ? numbers.get(o) : numbers.get(o) - 1)
                .filter(o -> o % 2 != 0)
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList
                .stream()
                .filter(m -> m.getSex() == Person.Sex.MAN
                        && m.getAge() > fromAge
                        && m.getAge() <= toAge)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList
                .stream()
                .filter(m -> m.getAge() >= fromAge)
                .filter(m -> m.getSex().equals(Person.Sex.WOMAN)
                        ? m.getAge() <= femaleToAge : m.getAge() <= maleToAge)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList
                .stream()
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
