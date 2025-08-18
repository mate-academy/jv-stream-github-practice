package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_TO_VOTE = 10;
    private static final int MIN_AGE_TO_VOTE = 35;
    private static final String REQUIRED_NATIONALITY_FOR_VOTE = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= MIN_AGE_TO_VOTE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY_FOR_VOTE)
                && calculatePeriodInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD_TO_VOTE
                && candidate.isAllowedToVote()) {
            return true;
        }
        return false;
    }

    private int calculatePeriodInUkr(String periodsInUkr) {
        String[] parts = periodsInUkr.split("-");
        return Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]);
    }
}
