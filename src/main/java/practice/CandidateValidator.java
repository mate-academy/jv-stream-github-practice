package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIODS_IN_UKRAINE = 10;
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
        return candidate != null
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && isValidPeriodsInUkraine(candidate.getPeriodsInUkr());
    }

    private static boolean isValidPeriodsInUkraine(String periodInUkr) {
        if (periodInUkr != null
                && periodInUkr.matches("\\d+" + SEPARATOR_IN_PERIOD + "\\d+")) {
            String[] range = periodInUkr.split(SEPARATOR_IN_PERIOD);
            return Integer.parseInt(range[1])
                    - Integer.parseInt(range[0]) + 1 >= MIN_PERIODS_IN_UKRAINE;
        }
        return false;
    }
}
