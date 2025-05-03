package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int PERIOD = 10;
    public static final int MIN_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriod(candidate) >= PERIOD;
    }

    private static int getPeriod(Candidate candidate) {
        return Arrays
                .stream(candidate.getPeriodsInUkr().split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .reduce(0, (accumulator, currentValue) -> currentValue - accumulator);
    }
}
