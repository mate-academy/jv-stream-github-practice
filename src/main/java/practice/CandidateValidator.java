package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int INCREMENT_NUMBER = 1;
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getPeriodsInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean getPeriodsInUkraine(String period) {
        int index = period.indexOf("-");
        return Integer.parseInt(period.substring(index + INCREMENT_NUMBER))
                - Integer.parseInt(period.substring(0, index)) >= MIN_PERIOD;
    }
}
