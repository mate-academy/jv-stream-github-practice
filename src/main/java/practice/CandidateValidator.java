package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVE_PERIOD = 10;
    private static final int LIVE_FROM_INDEX = 0;
    private static final int LIVE_TO_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
            && candidate.getAge() >= MIN_AGE
            && candidate.getNationality().equals(NATIONALITY)
            && isLivedEnough(candidate.getPeriodsInUkr());
    }

    private boolean isLivedEnough(String period) {
        String[] years = period.split("-");
        int livedPeriod = Integer.parseInt(years[LIVE_TO_INDEX])
                - Integer.parseInt(years[LIVE_FROM_INDEX]);
        return livedPeriod >= MIN_LIVE_PERIOD;
    }
}
