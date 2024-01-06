package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final int minAge = 35;
    private final String nationality = "Ukrainian";
    private final int minYearsInUkraine = 10;
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
        if (candidate.isAllowedToVote() && candidate.getClass().equals(Candidate.class)
                && candidate.getAge() >= minAge
                && candidate.getNationality().equals(nationality)) {
            String[] split = candidate.getPeriodsInUkr().split("-");
            return (Integer.parseInt(split[1]) - Integer.parseInt(split[0])) >= minYearsInUkraine;
        }
        return false;
    }
    //write your code here
}
