package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] parts = candidate.getPeriodsInUkr().split("-");
        int periodsInUkr = (Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]));
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodsInUkr >= MIN_PERIOD_IN_UKR;
    }
}
