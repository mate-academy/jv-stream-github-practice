package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }

        if (!candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }

        String periodInUkr = candidate.getPeriodsInUkr();
        String[] periods = periodInUkr.split("-");
        int start = Integer.parseInt(periods[1]);
        int end = Integer.parseInt(periods[0]);

        if ((start - end) < MIN_YEARS_IN_UKRAINE) {
            return false;
        }

        return true;
    }
}
