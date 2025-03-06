package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int startOfThePeriod = 0;
        int endOfThePeriod = 0;
        try {
            startOfThePeriod = Integer.parseInt(candidate.getPeriodsInUkr()
                    .substring(0, candidate.getPeriodsInUkr().indexOf("-")));
            endOfThePeriod = Integer.parseInt(candidate.getPeriodsInUkr()
                    .substring(candidate.getPeriodsInUkr().indexOf("-") + 1));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect period of time format");
        }
        return candidate.getAge() >= MINIMUM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (endOfThePeriod
                - startOfThePeriod >= MINIMUM_PERIOD_IN_UKRAINE);
    }
}
