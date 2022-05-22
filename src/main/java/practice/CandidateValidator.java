package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIM_AGE = 35;
    private static final int MIN_PERIOD_OF_RESIDENCE_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && liveInUkraineForYears(candidate) >= MIN_PERIOD_OF_RESIDENCE_UKRAINE;
    }

    private int liveInUkraineForYears(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        int periodFrom
                = Integer.parseInt(periodsInUkr.substring(0, periodsInUkr.indexOf("-")));
        int periodTo
                = Integer.parseInt(periodsInUkr.substring(periodsInUkr.indexOf("-") + 1,
                periodsInUkr.length()));
        return periodTo - periodFrom;
    }
}
