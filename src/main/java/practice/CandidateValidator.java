package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final int CANDIDATE_OLD_TO = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");

        try {
            int period = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);

            if (period < PERIOD_IN_UKRAINE) {
                return false;
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid period format: unable to parse year",e);
        }

        if (candidate.getAge() < CANDIDATE_OLD_TO) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }
        return true;
    }

}
