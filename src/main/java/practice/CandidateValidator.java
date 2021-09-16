package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_VALID_AGE_FROM = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int PERIOD_FROM_INDEX = 0;
    private static final int PERIOD_TO_INDEX = 1;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= CANDIDATE_VALID_AGE_FROM
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && Integer.parseInt(period[PERIOD_TO_INDEX])
                    - Integer.parseInt(period[PERIOD_FROM_INDEX]) >= MIN_PERIOD_IN_UKRAINE;
    }
}
