package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final int START_PERIOD_IN_UKR = 0;
    private static final int END_PERIOD_IN_UKR = 1;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (getPeriodInUkr(candidate) > MIN_PERIOD_IN_UKR
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && candidate.isAllowedToVote()) {
            return true;
        }
        return false;
    }

    private Integer getPeriodInUkr(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr()
                .split(DELIMITER)[END_PERIOD_IN_UKR])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split(DELIMITER)[START_PERIOD_IN_UKR]);
    }
}
