package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_CANDIDATE_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MINIMAL_YEARS_IN_COUNTRY = 10;
    private static final int FIRST_YEAR_IN_PERIOD_INDEX = 0;
    private static final int LAST_YEAR_IN_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MINIMAL_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && (Integer.parseInt(periodsInUkr[LAST_YEAR_IN_PERIOD_INDEX])
                - Integer.parseInt(periodsInUkr[FIRST_YEAR_IN_PERIOD_INDEX]))
                > MINIMAL_YEARS_IN_COUNTRY;
    }
}
