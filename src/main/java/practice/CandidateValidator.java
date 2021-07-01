package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN = "Ukrainian";
    private static final String DELIMITER = "-";
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int YEAR_TO = 1;
    private static final int YEAR_FROM = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && getYearsInUkraine(candidate.getPeriodsInUkr()) > MIN_YEARS_IN_UKRAINE;
    }

    private int getYearsInUkraine(String periods) {
        String[] years = periods.split(DELIMITER);
        return Integer.parseInt(years[YEAR_TO]) - Integer.parseInt(years[YEAR_FROM]);
    }
}
