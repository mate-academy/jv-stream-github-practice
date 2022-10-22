package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_VALID_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int YEAR_TO_INDEX = 1;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int MIN_PERIOD_IN_COUNTRY = 10;
    private static final String DATE_SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && calcPeriodInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_COUNTRY;
    }

    private int calcPeriodInUkr(String periodsInUkr) {
        String[] datePeriod = periodsInUkr.split(DATE_SPLIT_REGEX);
        return Integer.parseInt(datePeriod[YEAR_TO_INDEX])
                - Integer.parseInt(datePeriod[YEAR_FROM_INDEX]);
    }
}
