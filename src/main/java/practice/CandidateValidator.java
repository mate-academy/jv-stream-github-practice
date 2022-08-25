package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int PERIODS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
        return candidate.getAge() >= CANDIDATE_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote()
                && period >= PERIODS_IN_UKRAINE;
    }
}
