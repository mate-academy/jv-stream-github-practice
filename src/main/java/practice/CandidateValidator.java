package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REGEX = "-";
    private static final int REQUIRED_MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_MIN_PERIODS_IN_UKRAINE = 10;
    private static final int INDEX_OF_YEAR_FROM = 0;
    private static final int INDEX_OF_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(REGEX);
        int numberOfYearsInUkraine = Integer.parseInt(years[INDEX_OF_YEAR_TO])
                - Integer.parseInt(years[INDEX_OF_YEAR_FROM]);
        return candidate.getAge() >= REQUIRED_MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && numberOfYearsInUkraine >= REQUIRED_MIN_PERIODS_IN_UKRAINE;
    }
}
