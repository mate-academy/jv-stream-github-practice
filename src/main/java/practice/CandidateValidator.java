package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_LENGTH_OK = 2;
    private static final int MIN_LIVE_YEARS = 10;
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(NATIONALITY)) {
            return false;
        }
        String[] period = candidate.getPeriodsInUkr().split(SPLITTER);
        if (period.length != PERIOD_LENGTH_OK) {
            return false;
        }
        int start = Integer.parseInt(period[0]);
        int end = Integer.parseInt(period[1]);
        if ((end - start) < MIN_LIVE_YEARS) {
            return false;
        }
        return true;
    }
}
