package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_AGE = 35;
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";
    private static final int ELIGIBLE_RESIDENCE_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= ELIGIBLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ELIGIBLE_NATIONALITY)
                && (Integer.parseInt(yearsInUkr[1]) - Integer.parseInt(yearsInUkr[0]))
                >= ELIGIBLE_RESIDENCE_PERIOD;
    }
}
