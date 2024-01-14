package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONAL_IDENTITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_COUNTRY = 10;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;
    private static final int VALID_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate
                .isAllowedToVote()
                && isValidAge(candidate)
                && isValidNationality(candidate)
                && isValidMinPeriodInCountry(candidate);
    }

    private boolean isValidAge(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE;
    }

    private boolean isValidNationality(Candidate candidate) {
        return candidate
                .getNationality()
                .equals(NATIONAL_IDENTITY);
    }

    private boolean isValidMinPeriodInCountry(Candidate candidate) {
        return calculateMinPeriodInCountry(candidate) >= MIN_PERIOD_IN_COUNTRY;
    }

    private int calculateMinPeriodInCountry(Candidate candidate) {
        String[] yearList = candidate
                                .getPeriodsInUkr()
                                .split("-");
        return Integer.parseInt(yearList[END_YEAR])
                - Integer.parseInt(yearList[START_YEAR]);
    }
}
