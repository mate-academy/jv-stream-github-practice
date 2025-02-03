package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_AGE = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final int ZERO_FOR_YEAR = 0;
    private static final int ONE_FOR_YEAR = 1;
    private static final String DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split(DASH);
        int startYear = Integer.parseInt(split[ZERO_FOR_YEAR]);
        int endYear = Integer.parseInt(split[ONE_FOR_YEAR]);
        int result = endYear - startYear;
        return candidate.getAge() >= FROM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && result >= PERIOD_IN_UKRAINE;
    }
}
