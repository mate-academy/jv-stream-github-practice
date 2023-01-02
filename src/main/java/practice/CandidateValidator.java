package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_FOR_ELECTION = 35;
    private static final int FIRST_YEAR_IN_UKRAINE = 0;
    private static final int LAST_YEAR_IN_UKRAINE = 1;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        boolean isValidateCandidate = candidate.isAllowedToVote()
                && candidate.getAge() >= AGE_FOR_ELECTION
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[LAST_YEAR_IN_UKRAINE])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[FIRST_YEAR_IN_UKRAINE])
                >= MIN_PERIOD_IN_UKRAINE;
        return isValidateCandidate;
    }
}
