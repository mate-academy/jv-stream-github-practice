package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int periodInUkraine = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && (periodInUkraine) >= MIN_PERIOD_IN_UKRAINE && candidate.isAllowedToVote();
    }

}
