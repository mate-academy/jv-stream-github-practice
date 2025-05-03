package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] periods = periodsInUkr.split(PERIOD_SEPARATOR);
        int yearsInUkr = Integer.parseInt(periods[LAST_YEAR_INDEX])
                - Integer.parseInt(periods[FIRST_YEAR_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkr >= MIN_YEARS_IN_UKRAINE;
    }
}
