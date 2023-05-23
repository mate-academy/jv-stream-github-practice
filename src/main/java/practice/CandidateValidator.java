package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String HYPHEN = "-";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        int yearsInUa = getYearInUa(candidate.getPeriodsInUkr());
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUa >= MIN_PERIOD_IN_UKRAINE;
    }

    private int getYearInUa(String periodsInUkr) {
        String[] years = periodsInUkr.split(HYPHEN);
        return Integer.parseInt(years[END_INDEX]) - Integer.parseInt(years[START_INDEX]);
    }
}
