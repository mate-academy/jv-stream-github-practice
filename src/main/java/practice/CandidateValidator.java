package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int LIVE_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return isEligible(candidate);
    }

    private boolean isEligible(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && getPeriodsInUkrToInt(candidate) >= LIVE_PERIOD;
    }

    private int getPeriodsInUkrToInt(Candidate candidate) {
        String[] splitDates = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(splitDates[1]) - Integer.parseInt(splitDates[0]);
    }
}
