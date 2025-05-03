package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String SPLITTING_SYMBOL = "-";
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD_IN = 10;
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && getPeriodInUkraine(candidate) >= REQUIRED_PERIOD_IN;
    }

    private int getPeriodInUkraine(Candidate candidate) {
        String[] fromAndToYears = candidate.getPeriodsInUkr().split(SPLITTING_SYMBOL);
        int fromYear = Integer.parseInt(fromAndToYears[FROM_YEAR]);
        int toYear = Integer.parseInt(fromAndToYears[TO_YEAR]);
        return toYear - fromYear;
    }
}
