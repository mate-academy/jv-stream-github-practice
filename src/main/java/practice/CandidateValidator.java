package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_CANDIDATE_AGE = 35;
    private static final int REQUIRED_CANDIDATE_PERIOD = 10;
    private static final String REQUIRED_CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int PERIOD_FROM_INDEX = 0;
    private static final int PERIOD_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(period[PERIOD_TO_INDEX])
                - Integer.parseInt(period[PERIOD_FROM_INDEX]);
        return candidate.getAge() >= REQUIRED_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_CANDIDATE_NATIONALITY)
                && periodInUkraine >= REQUIRED_CANDIDATE_PERIOD;
    }
}
