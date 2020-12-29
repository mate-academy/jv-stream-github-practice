package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD = 10;
    private static final int DATE_LENGTH = 4;

    @Override
    public boolean test(Candidate candidate) {
        int fromPeriod = Integer.parseInt(candidate.getPeriodsInUkr().substring(0,DATE_LENGTH));
        int toPeriod = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().length() - DATE_LENGTH));
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && toPeriod - fromPeriod >= REQUIRED_PERIOD;
    }
}
