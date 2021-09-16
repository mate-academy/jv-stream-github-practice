package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T> implements Predicate<Candidate> {

    private static final int ALLOWED_AGE = 35;
    private static final int MINIMAL_DURATION = 10;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int durationInUkraine = Integer.parseInt(periodsInUkr[1])
                - Integer.parseInt(periodsInUkr[0]);
        return candidate.isAllowedToVote()
                && (candidate.getAge() >= ALLOWED_AGE)
                && (candidate.getNationality().equals(ALLOWED_NATIONALITY))
                && (durationInUkraine >= MINIMAL_DURATION);
    }
}
