package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKR = 10;
    private static final String NATIONALITY_UKR = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKR)
                && candidate.getAge() >= MIN_AGE
                && validateCandidatePeriodInUkr(candidate);
    }

    private boolean validateCandidatePeriodInUkr(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(years[YEAR_FROM_INDEX]);
        int toYear = Integer.parseInt(years[YEAR_TO_INDEX]);
        return (toYear - fromYear) >= REQUIRED_YEARS_IN_UKR;
    }
}
