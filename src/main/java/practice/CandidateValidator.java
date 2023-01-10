package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_COUNTRY = 10;
    private static final int REQUIRED_AGE = 35;
    private static final int FROM_DATE_INDEX = 0;
    private static final int TO_DATE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(years[TO_DATE_INDEX])
                - Integer.parseInt(years[FROM_DATE_INDEX]);
        return candidate.getAge() >= REQUIRED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsInUkraine >= REQUIRED_YEARS_IN_COUNTRY;
    }
}
