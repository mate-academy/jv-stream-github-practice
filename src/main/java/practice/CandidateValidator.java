package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_FROM_AGE = 35;
    private static final int CANDIDATE_PERIOD_IN_UKR = 10;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int START_PERIOD_INDEX = 1;
    private static final int END_PERIOD_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] parse = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(parse[START_PERIOD_INDEX])
                - Integer.parseInt(parse[END_PERIOD_INDEX]);
        return candidate.getAge() >= CANDIDATE_FROM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality() != null
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && period >= CANDIDATE_PERIOD_IN_UKR;
    }
}
