package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_VALID_AGE = 35;
    private static final int MIN_VALID_PERIOD_OF_RESIDENCE_IN_COUNTRY = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        int periodsInUkr = getPeriodOfLeaving(candidate);
        return candidate.getAge() >= MAX_VALID_AGE
                & candidate.isAllowedToVote()
                & candidate.getNationality().equals(REQUIRED_NATIONALITY)
                & periodsInUkr >= MIN_VALID_PERIOD_OF_RESIDENCE_IN_COUNTRY;
    }

    private int getPeriodOfLeaving(Candidate candidate) {
        String[] periodsYears = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);
        return Integer.parseInt(periodsYears[YEAR_TO_INDEX])
                - Integer.parseInt(periodsYears[YEAR_FROM_INDEX]);
    }
}
