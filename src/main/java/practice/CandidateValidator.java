package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final int MINIMAL_AGE = 35;
    private final int MINIMAL_PERIOD_IN_UKRAINE = 10;
    private final String UKRAINIAN_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int periodsInUkr = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        return candidate.getAge() >= MINIMAL_AGE && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && periodsInUkr >= MINIMAL_PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
