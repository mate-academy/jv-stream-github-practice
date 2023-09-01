package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final int YEAR_FROM_POSITION = 0;
    private static final int YEAR_TO_POSITION = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkYearsInUa(candidate);
    }

    private boolean checkYearsInUa(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearFrom = Integer.parseInt(years[YEAR_FROM_POSITION]);
        int yearTo = Integer.parseInt(years[YEAR_TO_POSITION]);
        return yearTo - yearFrom >= REQUIRED_YEARS_IN_UKRAINE;
    }
}
