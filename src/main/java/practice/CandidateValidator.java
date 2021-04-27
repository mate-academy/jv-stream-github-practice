package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_LIVING_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0])
                >= REQUIRED_PERIOD_LIVING_IN_UKRAINE;
    }
}
