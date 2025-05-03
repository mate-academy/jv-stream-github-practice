package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MINIMUM_AGE = 35;
    private static final String UKRAINE_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_LIVE_IN_UKRAINE = 10;
    private static final String PERIOD_YEARS_SPLITTER = "-";
    private static final int TO_YEAR_PERIOD_INDEX = 1;
    private static final int FROM_YEAR_PERIOD_INDEX = 0;

    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && UKRAINE_NATIONALITY.equals(candidate.getNationality())
                && candidate.isAllowedToVote()
                && getYearDiff(candidate.getPeriodsInUkr()) >= MIN_PERIOD_LIVE_IN_UKRAINE;
    }
    
    private int getYearDiff(String period) {
        String[] years = period.split(PERIOD_YEARS_SPLITTER);
        return Integer.parseInt(years[TO_YEAR_PERIOD_INDEX])
                - Integer.parseInt(years[FROM_YEAR_PERIOD_INDEX]);
    }
}
