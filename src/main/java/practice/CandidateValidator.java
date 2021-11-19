package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static int MIN_CANDIDATE_AGE = 35;
    private static String ALLOWED_NATIONALITY = "Ukrainian";
    private static int MIN_TERM_LIVE_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && Integer.parseInt(period[1]) - Integer.parseInt(period[0]) >= MIN_TERM_LIVE_IN_UKR;
    }
}
