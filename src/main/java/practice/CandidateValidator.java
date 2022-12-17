package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] liveInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && Integer.parseInt(liveInUkraine[TO_YEAR])
                - Integer.parseInt(liveInUkraine[FROM_YEAR]) > MIN_PERIOD_IN_UKRAINE;
    }
}
