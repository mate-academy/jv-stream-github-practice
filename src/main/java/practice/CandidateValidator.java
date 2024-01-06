package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int SECOND_YEAR_INDEX = 1;
    private static final int MINIMUM_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_PERIODS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && periodsToInt(candidate) >= MINIMUM_PERIODS_IN_UKRAINE;
    }

    private int periodsToInt(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[SECOND_YEAR_INDEX])
                - Integer.parseInt(years[FIRST_YEAR_INDEX]);
    }
    //write your code here
}
