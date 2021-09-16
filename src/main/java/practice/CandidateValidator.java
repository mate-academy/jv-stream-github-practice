package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int TO_YEAR = 1;
    private static final int FROM_YEAR = 0;
    private static final int YEARS_REQUIRED = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        boolean isPeriodInUkr = ((Integer.parseInt(years[TO_YEAR]))
                - (Integer.parseInt(years[FROM_YEAR])))
                >= YEARS_REQUIRED;
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian") && isPeriodInUkr;
    }
}
