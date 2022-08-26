package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEARS_LIVE_IN_UKRAINE = 10;
    private static final int MIN_YEARS_OLD = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        if (Integer.parseInt(period[1]) - Integer.parseInt(period[0]) < YEARS_LIVE_IN_UKRAINE) {
            return false;
        }
        if (!candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }
        if (candidate.getAge() < MIN_YEARS_OLD) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        return true;
    }
}
