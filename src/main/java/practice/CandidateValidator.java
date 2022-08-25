package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final boolean ALLOWED_TO_VOTE = true;
    private static final int PERIODS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int period =  Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
        if (candidate.getAge() >= CANDIDATE_AGE
        && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
        && candidate.isAllowedToVote() == ALLOWED_TO_VOTE
        && period >= PERIODS_IN_UKRAINE) {
            return true;
        }
        return false;
    }
}
