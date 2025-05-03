package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_MINIMUM = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_OF_LIVING_IN_STATE_MINIMUM = 10;
    private static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        boolean isValidAge = candidate.getAge() >= AGE_MINIMUM;
        boolean isValidNationality = candidate.getNationality().equals(NATIONALITY);
        boolean isAllowedToVote = candidate.isAllowedToVote();
        boolean isValidPeriodOfLiving = getPeriodLivingInState(candidate)
                > PERIOD_OF_LIVING_IN_STATE_MINIMUM;
        return isValidAge && isValidNationality && isAllowedToVote && isValidPeriodOfLiving;
    }

    private int getPeriodLivingInState(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(DELIMITER);
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
