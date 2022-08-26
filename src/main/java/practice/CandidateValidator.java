package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final int MIN_LIVE_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splittedPeriods = candidate.getPeriodsInUkr().split("-");

        return candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= MIN_ALLOWED_AGE
                && Integer.parseInt(splittedPeriods[1])
                - Integer.parseInt(splittedPeriods[0]) >= MIN_LIVE_YEARS_IN_UKRAINE;

    }
}
