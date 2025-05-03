package practice;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.Candidate;
import model.Cat;
import model.Person;

public class StreamPractice {
    private static final String COMMA_SPLITTER = ",";
    private static final IntUnaryOperator INCREMENT_VALUE_ON_ODD_POSITION = new IntUnaryOperator() {
        private int position = 1;

        @Override
        public int applyAsInt(int operand) {
            position++;
            return isEven(position) ? operand
                                    : operand - 1;
        }
    };
    private static final Function<Person, Stream<? extends String>> CAT_MAPPER = person ->
            person
                .getCats()
                .stream()
                .map(Cat::getName);
    private static final Function<String, IntStream> COMMA_SEPARATED_INTEGERS_FLAT_MAPPER =
            commaSeparatedIntegers ->
                    Arrays
                        .stream(commaSeparatedIntegers.split(COMMA_SPLITTER))
                        .mapToInt(Integer::parseInt);

    public int findMinEvenNumber(List<String> numbers) {
        Supplier<RuntimeException> exceptionSupplier = () ->
                new NoSuchElementException("Can't get min value from list: " + numbers);
        return numbers
                .stream()
                .flatMapToInt(COMMA_SEPARATED_INTEGERS_FLAT_MAPPER)
                .filter(StreamPractice::isEven)
                .min()
                .orElseThrow(exceptionSupplier);
    }

    public Double getOddNumsAverage(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(i -> i)
                .map(INCREMENT_VALUE_ON_ODD_POSITION)
                .filter(i -> !isEven(i))
                .average()
                .orElseThrow();
    }

    public List<Person> selectMenByAge(List<Person> peopleList, int fromAge, int toAge) {
        Predicate<Person> personPredicate = p ->
                p.getSex() == Person.Sex.MAN
                && p.getAge() >= fromAge
                && p.getAge() <= toAge;
        return peopleList
                .stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<Person> getWorkablePeople(
            int fromAge, int femaleToAge, int maleToAge, List<Person> peopleList
    ) {
        Predicate<Person> personPredicate = p ->
                p.getAge() >= fromAge
                && p.getAge() <= (p.getSex() == Person.Sex.MAN
                                  ? maleToAge
                                  : femaleToAge);
        return peopleList
                .stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
    }

    public List<String> getCatsNames(List<Person> peopleList, int femaleAge) {
        Predicate<Person> personPredicate = p ->
                p.getSex() == Person.Sex.WOMAN
                && p.getAge() >= femaleAge;
        return peopleList
                .stream()
                .filter(personPredicate)
                .flatMap(CAT_MAPPER)
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

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
