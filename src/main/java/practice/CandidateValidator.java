package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int VALID_PERIOD_IN_UKRAINE = 10;
    private static final String ukrainian = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(ukrainian)
                && candidate.isAllowedToVote()
                && Integer.parseInt(periodInUkraine[1])
                - Integer.parseInt(periodInUkraine[0]) >= VALID_PERIOD_IN_UKRAINE;
    }
}
