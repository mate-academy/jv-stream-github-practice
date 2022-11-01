package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATES = 35;
    private static final int MIN_YEARS_LIVE_IN_UKRAINE = 10;
    private static final int INDEX_BEGIN_PERIOD_IN_UKRAINE = 0;
    private static final int INDEX_LAST_PERIOD_IN_UKRAINE = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(split[INDEX_LAST_PERIOD_IN_UKRAINE])
                - Integer.parseInt(split[INDEX_BEGIN_PERIOD_IN_UKRAINE]);
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATES
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkraine >= MIN_YEARS_LIVE_IN_UKRAINE;
    }
}
