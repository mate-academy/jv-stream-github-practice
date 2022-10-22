package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_UKR = 10;
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && getIntUkrPeriod(candidate.getPeriodsInUkr()) >= MIN_PERIOD_UKR;
    }

    private Integer getIntUkrPeriod(String period) {
        return Integer.parseInt(period.substring(period.indexOf("-") + 1))
                - Integer.parseInt(period.substring(0, period.indexOf("-")));
    }
}
