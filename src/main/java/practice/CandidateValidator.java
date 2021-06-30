package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ACCEPTED_AGE = 35;
    private static final int ACCEPTED_NUMBERS_OF_YEARS_IN_UKRAINE = 10;
    private static final int INDEX_OF_LAST_YEAR_IN_UKRAINE = 1;
    private static final int INDEX_OF_FIRST_YEAR_IN_UKRAINE = 0;
    private static final String ACCEPTED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsLivedInUkraine = candidate.getPeriodsInUkr().split("-");
        if (Integer.parseInt(yearsLivedInUkraine[INDEX_OF_LAST_YEAR_IN_UKRAINE])
                - Integer.parseInt(yearsLivedInUkraine[INDEX_OF_FIRST_YEAR_IN_UKRAINE])
                < ACCEPTED_NUMBERS_OF_YEARS_IN_UKRAINE) {
            return false;
        }
        if (candidate.getAge() < ACCEPTED_AGE || !candidate.isAllowedToVote()) {
            return false;
        }
        return candidate.getNationality().equals(ACCEPTED_NATIONALITY);
    }
}
