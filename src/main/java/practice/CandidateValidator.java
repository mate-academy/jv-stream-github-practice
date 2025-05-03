package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String REQUIRED_NATIONALLY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALLY)
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && countPeriodInUkraine(candidate) >= MIN_PERIOD_IN_UKRAINE;
    }

    private static int countPeriodInUkraine(Candidate candidate) {
        String[] periodInUkraine = candidate
                .getPeriodsInUkr()
                .split("-");
        return Integer.parseInt(periodInUkraine[1])
                - Integer.parseInt(periodInUkraine[0]);
    }
}
