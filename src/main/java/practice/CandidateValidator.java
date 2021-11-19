package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static int MIN_CANDIDATE_AGE = 35;
    private final static String ALLOWED_NATIONALITY = "Ukrainian";
    private final static int MIN_TERM_LIVE_IN_UKR = 10;
    private final static int ARRIVAL_YEAR = 0;
    private final static int LAST_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && Integer.parseInt(period[LAST_YEAR]) - Integer.parseInt(period[ARRIVAL_YEAR])
                >= MIN_TERM_LIVE_IN_UKR;
    }
}
