package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 10;
    private static final int PERIOD = 10;
    private static final int FIRST_PART = 0;
    private static final int SECOND_PART = 1;
    private static final String URKAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int period = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[SECOND_PART])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[FIRST_PART]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(URKAINIAN)
                && period >= PERIOD;
    }
}
