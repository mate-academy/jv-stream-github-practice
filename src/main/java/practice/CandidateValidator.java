package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEARS_TO_IN_ARRAY = 1;
    private static final int YEARS_FROM_IN_ARRAY = 0;
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_COUNTRY = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        Integer yearsTo = Integer.parseInt(years[YEARS_TO_IN_ARRAY]);
        Integer yearsFrom = Integer.parseInt(years[YEARS_FROM_IN_ARRAY]);
        return candidate.isAllowedToVote() == true
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && (yearsTo - yearsFrom) >= REQUIRED_PERIOD_IN_COUNTRY;
    }
}
