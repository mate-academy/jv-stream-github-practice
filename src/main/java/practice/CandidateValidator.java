package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 10;
    private static final int PERIOD = 10;
    private static final int INDEX = 0;
    private static final int INDEX2 = 1;
    private static final String URKAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int period = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX2])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(URKAINIAN)
                && period >= PERIOD;
    }
}
