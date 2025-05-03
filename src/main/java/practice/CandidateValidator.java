package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_YEAR_IN_UKR = 0;
    private static final int TO_YEAR_IN_UKR = 1;
    private static final int AGE_VALID_FROM = 35;
    private static final int TERM_OF_LIVING_FROM = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkrAsArray = candidate.getPeriodsInUkr().split("-");
        int numberOfYearsInUkr = Integer.parseInt(periodInUkrAsArray[TO_YEAR_IN_UKR])
                - Integer.parseInt(periodInUkrAsArray[FROM_YEAR_IN_UKR]);
        return candidate.getAge() >= AGE_VALID_FROM && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && numberOfYearsInUkr >= TERM_OF_LIVING_FROM;
    }
}
