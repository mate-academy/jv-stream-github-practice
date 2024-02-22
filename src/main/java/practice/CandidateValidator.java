package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_AGE = 35;
    private static final int YEARS_IN_UKRAINE_NEEDED = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ELIGIBLE_AGE
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[LAST_YEAR_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[START_YEAR_INDEX])
                >= YEARS_IN_UKRAINE_NEEDED
                && candidate.isAllowedToVote();
    }
}
