package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String COUNTRY = "Ukrainian";
    private static final int MIN_LIVE_IN_COUNTRY = 10;
    private static final int INDEX_FROM_PERIOD = 0;
    private static final int INDEX_TO_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearLiveInUkraine = candidate.getPeriodsInUkr().split("-");
        int periodsInUkraine = Integer.parseInt(yearLiveInUkraine[INDEX_TO_PERIOD])
                - Integer.parseInt(yearLiveInUkraine[INDEX_FROM_PERIOD]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(COUNTRY)
                && periodsInUkraine > MIN_LIVE_IN_COUNTRY;
    }
}
