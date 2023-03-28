package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final String NATIONALITY_FOR_CANDIDATE = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitDatePeriod = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(splitDatePeriod[1])
                - Integer.parseInt(splitDatePeriod[0]);
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_FOR_CANDIDATE)
                && periodInUkraine >= MIN_PERIOD_IN_UKRAINE;
    }
}
