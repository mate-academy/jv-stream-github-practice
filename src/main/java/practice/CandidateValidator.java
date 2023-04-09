package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_LIVE_IN_UKRAINE = 10;
    private static final String UA_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(UA_NATIONALITY)
                && countPeriod(candidate) > MIN_YEARS_LIVE_IN_UKRAINE;
    }

    private int countPeriod(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
    }
}
