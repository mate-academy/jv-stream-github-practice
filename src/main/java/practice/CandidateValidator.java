package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote() && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && checkPeriod(candidate.getPeriodsInUkr()) >= MINIMUM_PERIOD_IN_UKRAINE;
    }

    public int checkPeriod(String period) {
        Integer startingDate = Integer.valueOf(period.substring(0, period.indexOf("-")));
        Integer endingDate = Integer.valueOf(period.substring(period.indexOf("-") + 1));
        return endingDate - startingDate;
    }
}
