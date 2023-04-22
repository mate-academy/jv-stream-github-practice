package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final String HYPHEN_PERIODS = "-";
    private static final int INDEX_FIRS_YEAR = 0;
    private static final int INDEX_LAST_YEAR = 1;
    private static final int MIN_LIVE_IN_COUNTRY = 10;
    
    @Override
    public boolean test(final Candidate c) {
        final String[] years = c.getPeriodsInUkr().split(HYPHEN_PERIODS);
        final int diffInYears = Integer.parseInt(years[INDEX_LAST_YEAR]) 
                          - Integer.parseInt(years[INDEX_FIRS_YEAR]);
        
        return c.getAge() >= MIN_AGE 
                && c.isAllowedToVote() == true 
                && c.getNationality().equals(NATIONALITY_UKR)
                && diffInYears >= MIN_LIVE_IN_COUNTRY 
                ? true : false;
    }
    
}
