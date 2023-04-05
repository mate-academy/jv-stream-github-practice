package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int START_PERIOD_INDEX = 0;
    private static final int FINISH_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(SEPARATOR);
        int startPeriodInUkr = Integer.parseInt(periodInUkr[START_PERIOD_INDEX]);
        int finishPeriodInUkr = Integer.parseInt(periodInUkr[FINISH_PERIOD_INDEX]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && finishPeriodInUkr - startPeriodInUkr >= LIVE_IN_UKRAINE;
    }
}
