package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String COUNTRY = "Ukrainian";
    private static final int MIN_LIVE_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearLiveInUkraine = candidate.getPeriodsInUkr().split("-");
        int periodsInUkraine = Integer.parseInt(yearLiveInUkraine[1])
                - Integer.parseInt(yearLiveInUkraine[0]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(COUNTRY)
                && periodsInUkraine > MIN_LIVE_IN_COUNTRY;
    }
}
