package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final int AGE_OF_CANDIDATE = 35;
    static final boolean ALLOWED_TO_VOTE = true;
    static final String NATIONALITY = "Ukrainian";
    static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_OF_CANDIDATE
                && candidate.isAllowedToVote() == ALLOWED_TO_VOTE
                && candidate.getNationality().equals(NATIONALITY)
                && getCandidatesPeriodInUkr(candidate) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int getCandidatesPeriodInUkr(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
    }
}
