package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static String REQUIRED_NATIONALITY = "Ukrainian";
    private final static int REQUIRED_AGE = 35;
    private final static int REQUIRED_PERIOD = 10;

    private int getIntOfPeriod(Candidate candidate) {
        return Integer.valueOf(candidate.getPeriodsInUkr().substring(5))
                - Integer.valueOf(candidate.getPeriodsInUkr().substring(0, 4));
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && (getIntOfPeriod(candidate)) >= REQUIRED_PERIOD;
    }
}
