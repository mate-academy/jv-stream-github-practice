package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;
    private static final String MINUS_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        String[] period = candidate.getPeriodsInUkr().split(MINUS_SEPARATOR);
        return Integer.parseInt(period[1])
                - Integer.parseInt(period[0]) >= MIN_YEARS_IN_UKRAINE;
    }
}
