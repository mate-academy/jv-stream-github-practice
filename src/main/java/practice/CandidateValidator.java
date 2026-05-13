package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() < MIN_AGE ? false 
                : !candidate.isAllowedToVote() ? false 
                : !candidate.getNationality().equals(UKRAINIAN_NATIONALITY) ? false 
                : Integer.parseInt(years[1]) - Integer.parseInt(years[0]) 
                        < MIN_YEARS_IN_UKRAINE ? false 
                : true;
    }
}
