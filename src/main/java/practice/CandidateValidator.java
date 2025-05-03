package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_LIVE_IN_UKRAINE = 10;
    private static final String REGEX = "-";
    private static final int INDEX_OF_FIRST_YEAR = 0;
    private static final int INDEX_OF_LAST_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] liveInUkraine = candidate.getPeriodsInUkr().split(REGEX);
        int years = Integer.parseInt(liveInUkraine[INDEX_OF_LAST_YEAR])
                - Integer.parseInt(liveInUkraine[INDEX_OF_FIRST_YEAR]);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && years >= MINIMUM_LIVE_IN_UKRAINE;
    }
}
