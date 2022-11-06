package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_LIVE_IN_COUNTRY = 10;
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final String SPLIT_LINE = "-";
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodLiveInUkraine = candidate.getPeriodsInUkr().split(SPLIT_LINE);
        int periodTime = Integer.parseInt(periodLiveInUkraine[LAST_YEAR_INDEX])
                - Integer.parseInt(periodLiveInUkraine[FIRST_YEAR_INDEX]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY)
                && periodTime >= MIN_PERIOD_LIVE_IN_COUNTRY;
    }
}
