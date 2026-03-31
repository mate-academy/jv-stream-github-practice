package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_AGE = 35;
    private static final int ELIGIBLE_TENURE = 10;
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int from = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int to = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);
        return candidate.getClass() == Candidate.class
                && candidate.getAge() >= ELIGIBLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ELIGIBLE_NATIONALITY)
                && to - from >= ELIGIBLE_TENURE;
    }
}
