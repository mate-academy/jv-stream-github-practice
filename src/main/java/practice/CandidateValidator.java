package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_APPLICATION_AGE = 35;
    private static final int MIN_RESIDENCE_TIME = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(ELIGIBLE_NATIONALITY)
                && candidate.getAge() >= MIN_APPLICATION_AGE
                && isValidYearsInUkr(candidate.getPeriodsInUkr());
    }

    private boolean isValidYearsInUkr(String periods) {
        String[] years = periods.split(SEPARATOR);
        return (Integer.parseInt(years[YEAR_TO_INDEX])
                - Integer.parseInt(years[YEAR_FROM_INDEX])) >= MIN_RESIDENCE_TIME;
    }
}
