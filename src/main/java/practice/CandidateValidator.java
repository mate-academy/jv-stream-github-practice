package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int START_AGE_FOR_VOTING = 35;
    private static final int MIN_ALLOWED_PERIOD_IN_UKR = 10;
    private static final int FIRST_ELEM_INDEX = 0;
    private static final int LEN_FIXER_FOR_INDEXES = 1;
    private static final String ALLOWED_COUNTY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= START_AGE_FOR_VOTING
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_COUNTY)
                && validatePeriodInUkr(candidate.getPeriodsInUkr());
    }

    private static boolean validatePeriodInUkr(String period) {
        String[] split = period.split("-");
        return Integer.parseInt(split[split.length - LEN_FIXER_FOR_INDEXES])
                - Integer.parseInt(split[FIRST_ELEM_INDEX]) >= MIN_ALLOWED_PERIOD_IN_UKR;
    }
}

