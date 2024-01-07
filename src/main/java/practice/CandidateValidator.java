package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_CHARACTER = "-";
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    /**
     * Evaluates this predicate on the given argument.
     *
     * @param o the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    /**
     * Evaluates this predicate on the given argument.
     *
     * @param candidate the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SPLIT_CHARACTER)[TO_YEAR_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SPLIT_CHARACTER)[FROM_YEAR_INDEX]))
                >= MIN_YEARS_IN_UKRAINE;
    }
}
