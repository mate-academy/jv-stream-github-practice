package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String SEPARATOR = ",";

    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .map(i -> Arrays.stream(i.split(SEPARATOR)).mapToInt(Integer::parseInt))
                .flatMapToInt(i -> i)
                .filter(i -> i % 2 == 0)
                .min()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list: "
                        + numbers));
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(index -> index % 2 == 1 ? numbers.get(index) - 1 : numbers.get(index))
                .filter(i -> i % 2 == 1)
                .average()
                .orElseThrow(() -> new NoSuchElementException("There are no suitable numbers "
                        + "in list: " + numbers));
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        return peopleList.stream()
                .filter(new FilterManByAge(fromAge, toAge))
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(int fromAge, int femaleToAge,
                                          int maleToAge, List<Person> peopleList) {
        return peopleList.stream()
                .filter(new FilterWorkablePeople(fromAge, femaleToAge, maleToAge))
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        return peopleList.stream()
                .filter(i -> i.getSex() == Person.Sex.WOMAN && i.getAge() >= femaleAge)
                .flatMap(i -> i.getCats().stream())
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

    private static class FilterManByAge implements Predicate<Person> {
        private final int fromAge;
        private final int toAge;

        public FilterManByAge(int fromAge, int toAge) {
            this.fromAge = fromAge;
            this.toAge = toAge;
        }

        @Override
        public boolean test(Person person) {
            return person.getAge() >= fromAge
                    && person.getAge() <= toAge
                    && person.getSex() == Person.Sex.MAN;
        }
    }

    private static class FilterWorkablePeople implements Predicate<Person> {
        private final int fromAge;
        private final int femaleToAge;
        private final int maleToAge;

        public FilterWorkablePeople(int fromAge, int femaleToAge, int maleToAge) {
            this.fromAge = fromAge;
            this.femaleToAge = femaleToAge;
            this.maleToAge = maleToAge;
        }

        @Override
        public boolean test(Person person) {
            return person.getAge() >= fromAge
                    && (person.getSex() == Person.Sex.MAN
                    ? person.getAge() <= maleToAge : person.getAge() <= femaleToAge);
        }
    }
}
