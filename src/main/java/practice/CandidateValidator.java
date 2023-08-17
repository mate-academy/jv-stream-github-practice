package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_OF_RESIDENCE_IN_UKRAINE = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MAX_AGE || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }
        String periodsInUkr = candidate.getPeriodsInUkr();
        if (periodsInUkr != null) {
            String[] years = periodsInUkr.split("-");
            if (years.length == 2) {
                int startYear = Integer.parseInt(years[START_YEAR_INDEX]);
                int endYear = Integer.parseInt(years[END_YEAR_INDEX]);
                int yearsInUkraine = endYear - startYear;
                return yearsInUkraine >= PERIOD_OF_RESIDENCE_IN_UKRAINE;
            }
        }
        return true;
    }
}
