package practice;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DELETE_SYMBOL = "-";

    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && checkTimeLivingInCountry(candidate) >= MIN_PERIOD;
    }

    private static int checkTimeLivingInCountry(Candidate candidate) {
        return Stream.of(candidate.getPeriodsInUkr())
                .map(n -> n.split(DELETE_SYMBOL))
                .map(arr -> new int[]{
                        Integer.parseInt(arr[FIRST_INDEX]), Integer.parseInt(arr[SECOND_INDEX])
                }).map(arr -> arr[SECOND_INDEX] - arr[FIRST_INDEX])
                .mapToInt(Integer::intValue).findAny()
                .orElseThrow(() -> new NoSuchElementException("invalid data"));
    }
}
