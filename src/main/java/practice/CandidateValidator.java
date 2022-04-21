package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int LIVE_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int startPeriod = Integer.parseInt(period[0]);
        int endPeriod = Integer.parseInt(period[1]);
        if ((endPeriod - startPeriod) >= LIVE_IN_COUNTRY) {
            return true;
        }
        return false;
    }
}
