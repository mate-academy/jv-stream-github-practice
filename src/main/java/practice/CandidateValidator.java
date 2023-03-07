package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIODS_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR_IN_PERIOD = "-";

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param candidate the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && isValidPeriodsInUkr(candidate.getPeriodsInUkr());
    }

    private boolean isValidPeriodsInUkr(String periodInUkr) {
        if (periodInUkr == null) {
            return false;
        }
        String[] range = periodInUkr.split(SEPARATOR_IN_PERIOD);
        try {
            return Integer.parseInt(range[1])
                    - Integer.parseInt(range[0]) + 1 >= MIN_PERIODS_IN_UKR;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
