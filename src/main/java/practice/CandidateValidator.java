package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final int VALID_PERIOD = 10;
    private static final int NULL_INDEX = 0;
    private static final int ONE_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && getYearsInUkr(candidate) >= VALID_PERIOD;
    }

    private int getYearsInUkr(Candidate candidate) {
        String[] periodString = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(periodString[ONE_INDEX])
                - Integer.parseInt(periodString[NULL_INDEX]);
    }
}
