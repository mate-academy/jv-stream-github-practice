package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int YEARS = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_PERIOD = 0;
    private static final int END_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= AGE && candidate.isAllowedToVote()
                && candidate.getNationality() == NATIONALITY
                && (Integer.parseInt(years[END_PERIOD])
                - Integer.parseInt(years[START_PERIOD])) > YEARS;
    }
    //write your code here

}
