package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 18;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int NUMBER_OF_FIRST_YEAR = 0;
    private static final int NUMBER_OF_LAST_YEAR = 1;
    private static final int MIN_AMOUNT_OF_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() > MIN_CANDIDATE_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && getAmountYearsInUkraine(candidate) > MIN_AMOUNT_OF_YEARS_IN_UKRAINE;
    }

    private int getAmountYearsInUkraine(Candidate candidate) {
        String[] firstAndLastYear = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(firstAndLastYear[NUMBER_OF_LAST_YEAR])
                - Integer.parseInt(firstAndLastYear[NUMBER_OF_FIRST_YEAR]);
    }
}
