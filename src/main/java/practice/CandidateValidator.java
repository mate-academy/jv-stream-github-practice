package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_UKRAINE = 10;
    private static final int PERIOD_TIME_FROM = 0;
    private static final int PERIOD_TIME_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodTime = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && Integer.parseInt(periodTime[PERIOD_TIME_TO])
                - Integer.parseInt(periodTime[PERIOD_TIME_FROM]) >= LIVE_IN_UKRAINE;
    }
}
