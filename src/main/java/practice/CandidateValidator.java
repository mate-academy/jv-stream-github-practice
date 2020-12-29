package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equalsIgnoreCase(NATIONALITY)
                && candidate.isAllowedToVote()
                && periodsInUkr(candidate.getPeriodsInUkr()) >= LIVE_IN_UKRAINE
                && candidate.getAge() >= AGE;
    }

    private int periodsInUkr(String periodsInUkr) {
        String[] periodInUkr = periodsInUkr.split("-");
        return Integer.parseInt(periodInUkr[1]) - Integer.parseInt(periodInUkr[0]);
    }

}
