package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_InUKR = 10;
    private static final int CANDIDATE_ValidAGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return getPeriodsInUkr(candidate.getPeriodsInUkr()) > PERIOD_InUKR
                && candidate.isAllowedToVote() && candidate.getAge() >= CANDIDATE_ValidAGE
                && candidate.getNationality().equals(VALID_NATIONALITY);
    }

    private int getPeriodsInUkr(String getPeriodsInUkr) {
        String[] period = getPeriodsInUkr.split("-");
        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
    }
}
