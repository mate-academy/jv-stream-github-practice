package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int startOfThePeriod = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0,candidate.getPeriodsInUkr().indexOf("-")));
        int endOfThePeriod = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().indexOf("-") + 1));
        return candidate.getAge() >= MINIMUM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (endOfThePeriod
                - startOfThePeriod >= MINIMUM_PERIOD_IN_UKRAINE);
    }
}
