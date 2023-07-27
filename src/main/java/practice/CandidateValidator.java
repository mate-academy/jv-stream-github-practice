package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final int MINIMAL_YEARS_IN_UKRAINE = 10;
    private static final String DIVIDER = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_OF_START_YEAR = 0;
    private static final int INDEX_OF_END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && hasRequiredYearsInUkraine(candidate.getPeriodsInUkr());

    }

    private boolean hasRequiredYearsInUkraine(String periodsInUkraine) {
        String[] years = periodsInUkraine.split(DIVIDER);
        int yearsAmount = Integer.parseInt(years[INDEX_OF_END_YEAR])
                - Integer.parseInt(years[INDEX_OF_START_YEAR]);
        return yearsAmount >= 10;
    }
}
