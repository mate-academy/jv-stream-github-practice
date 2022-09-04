package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int LIVE_IN_UKR_FROM = 0;
    private static final int LIVE_IN_UKR_TO = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriodLiveInUkraine(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int getPeriodLiveInUkraine(String periodsInUkr) {
        String[] period = periodsInUkr.split("-");
        return Integer.parseInt(period[LIVE_IN_UKR_TO])
                - Integer.parseInt(period[LIVE_IN_UKR_FROM]);
    }
}
