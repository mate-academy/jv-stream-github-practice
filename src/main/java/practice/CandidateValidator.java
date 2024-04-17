package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEAR_LIVE = 10;
    private static final int PERIOD_LIVE_FROM = 0;
    private static final int PERIOD_LIVE_TO = 1;
    private static final String NATIONAL = "ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        boolean checkPeriod = Integer.parseInt(periods[PERIOD_LIVE_TO])
                - Integer.parseInt(periods[PERIOD_LIVE_FROM]) > MIN_YEAR_LIVE;

        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equalsIgnoreCase(NATIONAL)
                && candidate.isAllowedToVote()
                && checkPeriod;
    }
}
