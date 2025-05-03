package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ELIGIBLE_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {

        return candidate.getAge() >= MIN_ELIGIBLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && isEligible(candidate.getPeriodsInUkr());
    }

    private boolean isEligible(String years) {
        String[] yearsInUkraine = years.split("-");
        return Integer.parseInt(yearsInUkraine[1])
                - Integer.parseInt(yearsInUkraine[0]) >= MIN_YEARS_IN_UKRAINE;
    }
}
