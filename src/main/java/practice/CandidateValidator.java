package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_LIVE_IN_COUNTRY = 10;
    private static final int MIN_VALID_AGE = 35;
    private static final int START_SUBSTRING_INDEX = 0;
    private static final int SLIDER_TO_START_SUBSTRING_INDEX = 1;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final char DIVIDER_IN_LIVE_PERIOD = '-';

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_VALID_AGE
                && VALID_NATIONALITY.equals(candidate.getNationality())
                && yearsLiveInUkraine(candidate) >= MIN_PERIOD_LIVE_IN_COUNTRY;
    }

    private int yearsLiveInUkraine(Candidate candidate) {
        String liveInUkraine = candidate.getPeriodsInUkr();
        int fromYear = Integer.parseInt(
                liveInUkraine.substring(START_SUBSTRING_INDEX,liveInUkraine.indexOf(DIVIDER_IN_LIVE_PERIOD)));
        int upToYear = Integer.parseInt(
                liveInUkraine.substring(liveInUkraine.indexOf(DIVIDER_IN_LIVE_PERIOD)
                        + SLIDER_TO_START_SUBSTRING_INDEX));
        return upToYear - fromYear;
    }
}
