package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATES_REQUIRED_AGE = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= CANDIDATES_REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(periodInUkraine[1])
                - Integer.parseInt(periodInUkraine[0]) >= PERIOD_IN_UKRAINE;
    }
}
