package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_YEARS = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_YEARS_LIVE_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split("-");
        int intYearsInUkr = Integer.parseInt(yearsInUkr[1]) - Integer.parseInt(yearsInUkr[0]);
        return candidate.getAge() >= MINIMAL_YEARS
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && intYearsInUkr >= MINIMAL_YEARS_LIVE_IN_UKR;
    }
}
