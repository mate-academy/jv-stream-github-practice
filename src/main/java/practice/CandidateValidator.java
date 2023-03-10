package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DATE_SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        int period = Arrays.stream(candidate.getPeriodsInUkr().split(DATE_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .reduce((start, end) -> end - start)
                .orElse(0);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && period >= MIN_PERIOD;
    }
}
