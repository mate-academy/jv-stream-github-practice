package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_REQUIRED_AGE = 35;
    private static final int CANDIDATE_LIVE_IN_UKR = 10;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int livingPeriod = Integer.parseInt(candidate.getPeriodsInUkr().substring(5))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4));

        return candidate.getAge() >= CANDIDATE_REQUIRED_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote()
                && livingPeriod >= CANDIDATE_LIVE_IN_UKR;
    }
}
