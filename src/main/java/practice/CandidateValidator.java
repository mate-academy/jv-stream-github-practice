package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int INDEX_FOR_START_YEAR = 0;
    private static final int INDEX_FOR_END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsInUkr(candidate) >= REQUIRED_YEARS_IN_UKRAINE;
    }

    private int yearsInUkr(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[INDEX_FOR_END_YEAR])
                - Integer.parseInt(years[INDEX_FOR_START_YEAR]);
    }
}
