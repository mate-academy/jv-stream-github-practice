package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int AGE_FOR_VOTING = 35;
    private static final int LIVE_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= AGE_FOR_VOTING
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && livingInUkr(candidate) >= LIVE_IN_UKR) {
            return true;
        }
        return false;
    }

    private int livingInUkr(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodInUkraine[1]) - Integer.parseInt(periodInUkraine[0]);
    }
}
