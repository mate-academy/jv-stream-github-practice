package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final int START_POINT_INDEX = 0;
    private static final int END_POINT_INDEX = 1;
    private static final String YEARS_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);
        int firstYear = Integer.parseInt(years[START_POINT_INDEX]);
        int lastYear = Integer.parseInt(years[END_POINT_INDEX]);

        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && lastYear - firstYear >= MIN_PERIOD;
    }
}
