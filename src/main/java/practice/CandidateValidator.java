package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_YEARS = 35;
    private static final int REQUIRED_LIVING_YEARS = 10;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";


    //write your code here

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(years[FROM_YEAR_INDEX]);
        int toYear = Integer.parseInt(years[TO_YEAR_INDEX]);

        return candidate.getAge() >= REQUIRED_YEARS
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && toYear - fromYear >= REQUIRED_LIVING_YEARS;
    }
}
