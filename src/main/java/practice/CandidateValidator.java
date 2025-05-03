package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LIMIT = 35;
    private static final int YEARS_LIMIT = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_LIMIT && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && getTimePeriodOfLiving(candidate) > YEARS_LIMIT;
    }

    private static int getTimePeriodOfLiving(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLITTER);
        return Math.abs(Integer.parseInt(years[START_YEAR_INDEX])
                - Integer.parseInt(years[END_YEAR_INDEX]));
    }
}
