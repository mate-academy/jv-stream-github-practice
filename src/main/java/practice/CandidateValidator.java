package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;
    private static final String DASH = "-";
    private static final int BEGINNING = 0;
    private static final int END = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (checkYear(candidate));
    }

    private boolean checkYear(Candidate candidate) {
        String[] livingInUkraine = candidate.getPeriodsInUkr().split(DASH);
        try {
            return Integer.parseInt(livingInUkraine[END])
                    - Integer.parseInt(livingInUkraine[BEGINNING]) >= MINIMUM_PERIOD_IN_UKRAINE;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The number format is incorrect");
        }
    }
}
