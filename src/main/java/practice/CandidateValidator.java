package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int AGE_LOWER_BOUND = 35;
    private static final int NEEDED_PERIOD_OF_LIVING = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && candidate.getAge() >= AGE_LOWER_BOUND
                && getPeriodOfLiving(candidate) >= NEEDED_PERIOD_OF_LIVING;
    }

    private int getPeriodOfLiving(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
    }
}
