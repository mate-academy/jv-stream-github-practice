package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_OLD = 35;
    private static final boolean ALLOWED_TO_VOTE = true;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_OLD
                && candidate.isAllowedToVote() == ALLOWED_TO_VOTE
                && candidate.getNationality().equals(NATIONALITY)
                && periodLiveInUkraine(candidate.getPeriodsInUkr()) > MIN_PERIOD_LIVE_IN_UKRAINE;
    }

    private int periodLiveInUkraine(String periodsInUkraine) {
        String[] dates = periodsInUkraine.split("-");
        return Arrays.stream(dates)
                .mapToInt(Integer::parseInt)
                .reduce((startDate, endDate) -> endDate - startDate)
                .orElse(0);
    }
}
