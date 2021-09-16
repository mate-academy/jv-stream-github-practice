package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final int FROM_YEAR_IN_UKR = 0;
    private static final int TO_YEAR_IN_UKR = 1;
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final String UKR_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(UKR_NATIONALITY)
                && Integer.parseInt(yearsInUkr[TO_YEAR_IN_UKR])
                - Integer.parseInt(yearsInUkr[FROM_YEAR_IN_UKR]) >= MIN_YEARS_IN_UKR;
    }
}
