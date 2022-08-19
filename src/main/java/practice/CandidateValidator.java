package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_MINIMUM = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_LIVE_PERIOD = 10;
    private static final int PERIOD_FROM = 0;
    private static final int PERIOD_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] dataPeriod = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= AGE_MINIMUM
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(dataPeriod[PERIOD_TO])
                - Integer.parseInt(dataPeriod[PERIOD_FROM]) >= MIN_LIVE_PERIOD;
    }
}
