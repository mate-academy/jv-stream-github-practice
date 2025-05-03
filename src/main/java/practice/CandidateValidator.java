package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 0;
    private static final String PERIOD_DIVIDER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(PERIOD_DIVIDER);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(periodInUkraine[FIRST_INDEX])
                - Integer.parseInt(periodInUkraine[SECOND_INDEX]) >= MIN_PERIOD_IN_UKRAINE;
    }
}
