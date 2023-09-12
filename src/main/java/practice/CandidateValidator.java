package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int PERIOD_IN_UKR = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";
    private static final byte FIRST_PART = 0;
    private static final byte SECOND_PART = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && calculateTimeLiving(candidate);
    }

    private boolean calculateTimeLiving(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(REGEX);
        return Integer.parseInt(dates[SECOND_PART])
                - Integer.parseInt(dates[FIRST_PART]) >= PERIOD_IN_UKR;
    }
}
