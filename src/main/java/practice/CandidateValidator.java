package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int START_AGE_FOR_VOTING = 35;
    private static final int MIN_ALLOWED_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= START_AGE_FOR_VOTING
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && validatePeriodInUkr(candidate.getPeriodsInUkr());
    }

    private static boolean validatePeriodInUkr(String period) {
        String[] split = period.split("-");
        return Integer.parseInt(split[split.length - 1])
                - Integer.parseInt(split[0]) >= MIN_ALLOWED_PERIOD_IN_UKR;
    }
}

