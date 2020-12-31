package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int OLDER = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int periodsInUkr = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        return candidate.getAge() >= OLDER && candidate.getNationality().equals(NATIONALITY)
                && periodsInUkr >= PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}

