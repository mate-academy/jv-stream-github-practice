package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int AGE_LIMIT = 35;
    private static final int PERIODS_IN_UKR_LIMIT = 10;
    private static final boolean BE_ALLOWED_TO_VOTE = true;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_LIMIT
                && periodsInUkrValidator(candidate.getPeriodsInUkr(),PERIODS_IN_UKR_LIMIT)
                && candidate.isAllowedToVote() == BE_ALLOWED_TO_VOTE
                && candidate.getNationality().equals(NATIONALITY);
    }

    private boolean periodsInUkrValidator(String actualPeriod, int periodsLimit) {
        String[] years = actualPeriod.split(SEPARATOR);
        return (Integer.parseInt(years[1]) - Integer.parseInt(years[0]))
                > periodsLimit;
    }
}
