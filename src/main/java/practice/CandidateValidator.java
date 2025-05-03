package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int OLDER_THEN = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEAR_LIVE_IN_UKRAINE = 10;
    private static final boolean ALLOWED_TO_VOTE = true;
    private static final String REGEX = "-";
    private static final int LAST_YEAR = 1;
    private static final int FIRST_YEAR = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(REGEX);
        int totalYearInUkraine = Integer.parseInt(periodInUkraine[LAST_YEAR])
                - Integer.parseInt(periodInUkraine[FIRST_YEAR]);
        return candidate.getAge() >= OLDER_THEN
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote() == ALLOWED_TO_VOTE
                && totalYearInUkraine >= YEAR_LIVE_IN_UKRAINE;
    }
}
