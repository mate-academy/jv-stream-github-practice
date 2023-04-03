package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String CITIZENSHIP = "Ukrainian";
    private static final int MINIMUM_TIME_IN_THE_COUNTRY = 10;
    private static final int PERIOD_INT_UKRAINE_START = 0;
    private static final int PERIOD_INT_UKRAINE_END = 1;

    @Override
    public boolean test(Candidate candidate) {
        final String[] periodCandidate = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CITIZENSHIP)
                && (Integer.parseInt(periodCandidate[PERIOD_INT_UKRAINE_END])
                - (Integer.parseInt(periodCandidate[PERIOD_INT_UKRAINE_START])))
                >= MINIMUM_TIME_IN_THE_COUNTRY;
    }
}
