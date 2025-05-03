package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String NATIONALITY_FOR_CANDIDATE = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int START_OF_PERIOD = 0;
    private static final int END_OF_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_FOR_CANDIDATE)
                && hasLived(candidate);
    }

    private boolean hasLived(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(split[END_OF_PERIOD])
                - Integer.parseInt(split[START_OF_PERIOD]) >= MIN_PERIOD_IN_UKRAINE;
    }
}
