package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVING_PERIOD = 10;
    private static final int START_LIVING_DATA = 0;
    private static final int CURRENT_LIVING_DATA = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && hasLivedInUkraineForAtLeast10Years(candidate.getPeriodsInUkr());
    }

    public boolean hasLivedInUkraineForAtLeast10Years(String periodsInUkr) {
        String[] period = periodsInUkr.split("-");
        if (periodsInUkr == null) {
            return false;
        }
        return Math.abs(Integer.parseInt(period[START_LIVING_DATA])
                - Integer.parseInt(period[CURRENT_LIVING_DATA])) >= LIVING_PERIOD;
    }
}
