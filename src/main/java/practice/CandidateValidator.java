package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_LIVING_IN_UKRAINE = 10;
    private static final String NATIONALLY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(NATIONALLY)
                && countPeriodLivedInUkraine(candidate) >= MIN_LIVING_IN_UKRAINE;
    }

    private int countPeriodLivedInUkraine(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
    }
}
