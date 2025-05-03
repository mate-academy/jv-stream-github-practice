package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIODS_IN_UKR = 10;
    private static final int LAST_YEAR_IN_UKR_INDEX = 1;
    private static final int FIRST_YEAR_IN_UKR_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] splittedPeriodInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= REQUIRED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(splittedPeriodInUkr[LAST_YEAR_IN_UKR_INDEX])
                - Integer.parseInt(splittedPeriodInUkr[FIRST_YEAR_IN_UKR_INDEX])
                >= REQUIRED_PERIODS_IN_UKR;
    }
}
