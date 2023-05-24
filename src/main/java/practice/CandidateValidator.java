package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int OLDER_THAN = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_UKRAINE = 10;
    private static final String REGEX = "-";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(REGEX);
        int liveInUkraine = Integer.parseInt(periodInUkraine[TO_YEAR])
                - Integer.parseInt(periodInUkraine[FROM_YEAR]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= OLDER_THAN
                && candidate.getNationality().equals(NATIONALITY)
                && liveInUkraine >= LIVE_IN_UKRAINE;
    }
}
