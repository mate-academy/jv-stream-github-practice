package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int ALLOWED_AGE = 35;
    private static final int THRESHOLD_LIVING_AGE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= ALLOWED_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]))
                >= THRESHOLD_LIVING_AGE;
    }
}
