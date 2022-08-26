package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEARS_LIVE_IN_UKRAINE = 10;
    private static final int MIN_YEARS_OLD = 35;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(DASH);
        if (Integer.parseInt(period[SECOND_INDEX]) - Integer.parseInt(period[FIRST_INDEX])
                < YEARS_LIVE_IN_UKRAINE) {
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
