package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_AMOUNT_OF_YEARS_IN_COUNTRY = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIODS_SEPARATOR = "-";
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkAmountOfYearsInCountry(candidate);
    }

    private boolean checkAmountOfYearsInCountry(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr()
                .split(PERIODS_SEPARATOR)[END_PERIOD_INDEX])
                        - Integer.parseInt(candidate.getPeriodsInUkr()
                .split(PERIODS_SEPARATOR)[START_PERIOD_INDEX])
                        >= REQUIRED_AMOUNT_OF_YEARS_IN_COUNTRY;
    }
}
