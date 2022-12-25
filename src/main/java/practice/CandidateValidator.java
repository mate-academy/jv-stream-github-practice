package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQ_NATIONALITY = "Ukrainian";
    private static final int FROM_YEAR_INDEX = 0;    
    private static final int TO_YEAR_INDEX = 1;    
    
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35 
                && candidate.isAllowedToVote() == true 
                && candidate.getNationality().equals(REQ_NATIONALITY) 
                && getYearsInCounty(candidate.getPeriodsInUkr()) >= 10;
    }

    private int getYearsInCounty(String period) {
        String[] years = period.split("-");
        return Integer.parseInt(years[TO_YEAR_INDEX]) 
                - Integer.parseInt(years[FROM_YEAR_INDEX]);
    }
}
