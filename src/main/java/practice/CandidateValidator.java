package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_AGE = 35;
    private static final int MINIMAL_PERIOD_UKRAINE_RESIDENCE = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    private int calculateAgeDifference(String periodsInUkraine) {
        String[] years = periodsInUkraine.split("-");
        if (years.length == 2) {
            int startYear = Integer.parseInt(years[START_YEAR_INDEX]);
            int endYear = Integer.parseInt(years[END_YEAR_INDEX]);
            return endYear - startYear;
        }
        return 0;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMAL_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && calculateAgeDifference(candidate.getPeriodsInUkr())
                > MINIMAL_PERIOD_UKRAINE_RESIDENCE;
    }
}
