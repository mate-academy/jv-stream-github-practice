package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_INDEX_START = 0;
    private static final int LAST_INDEX_END = 1;
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY_FOR_CANDIDATE = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] splitDatePeriod = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(splitDatePeriod[LAST_INDEX_END])
                - Integer.parseInt(splitDatePeriod[FIRST_INDEX_START]);
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_FOR_CANDIDATE)
                && periodInUkraine >= MIN_PERIOD_IN_UKRAINE;
    }
}
