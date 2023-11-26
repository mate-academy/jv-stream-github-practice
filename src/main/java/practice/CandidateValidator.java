package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_LIVE_IN_COUNTRY = 10;
    private static final int MIN_VALID_AGE = 35;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int UP_TO_YEAR_INDEX = 1;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String DIVIDER_DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_VALID_AGE
                && VALID_NATIONALITY.equals(candidate.getNationality())
                && yearsLiveInUkraine(candidate) >= MIN_PERIOD_LIVE_IN_COUNTRY;
    }

    private int yearsLiveInUkraine(Candidate candidate) {
        String liveInUkraine = candidate.getPeriodsInUkr();
        int fromYear = Integer.parseInt(liveInUkraine.split(DIVIDER_DASH)[FROM_YEAR_INDEX]);
        int upToYear = Integer.parseInt(liveInUkraine.split(DIVIDER_DASH)[UP_TO_YEAR_INDEX]);
        return upToYear - fromYear;
    }
}
