package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int SHOULD_BE_OLDER_THAN = 35;
    private static final int MUST_LIVE_MORE_THAN = 10;

    @Override
    public boolean test(Candidate candidate) {
        int liveFrom;
        int liveTo;
        String[] years = candidate.getPeriodsInUkr().split("-");
        liveFrom = Integer.parseInt(years[0]);
        liveTo = Integer.parseInt(years[1]);
        return candidate.getAge() >= SHOULD_BE_OLDER_THAN && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && liveTo - liveFrom >= MUST_LIVE_MORE_THAN;
    }
}
