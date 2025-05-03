package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEARS_SPLITTER = "-";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        int yearsInUkr = getYearsInUkr(candidate.getPeriodsInUkr());
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkr >= MIN_PERIOD_IN_UKR;
    }

    private int getYearsInUkr(String periodsInUkr) {
        String[] years = periodsInUkr.split(YEARS_SPLITTER);
        return Integer.parseInt(years[END_INDEX]) - Integer.parseInt(years[START_INDEX]);
    }
}
