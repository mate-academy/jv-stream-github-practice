package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int TO_YEAR_IN_UKRAINE_INDEX = 1;
    private static final int FROM_YEAR_IN_UKRAINE_INDEX = 0;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String PERIODS_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && getYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int getYearsInUkraine(String periodsInUkr) {
        String[] periodSeparated = periodsInUkr.split(PERIODS_SEPARATOR);
        return Integer.parseInt(periodSeparated[TO_YEAR_IN_UKRAINE_INDEX])
                - Integer.parseInt(periodSeparated[FROM_YEAR_IN_UKRAINE_INDEX]);
    }
}
