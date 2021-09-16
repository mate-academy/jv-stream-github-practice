package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int TO_YEAR = 1;
    private static final int FROM_YEAR = 0;
    private static final int YEARS_REQUIRED = 10;
    private static final int AGE_REQUIRED = 35;
    private static final String NATIONALITY_REQUIRED = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        boolean isPeriodInUkr = ((Integer.parseInt(years[TO_YEAR]))
                - (Integer.parseInt(years[FROM_YEAR])))
                >= YEARS_REQUIRED;
        return candidate.getAge() >= AGE_REQUIRED && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_REQUIRED)
                && isPeriodInUkr;
    }
}
