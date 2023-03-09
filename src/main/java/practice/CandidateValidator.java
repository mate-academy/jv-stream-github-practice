package practice;

import java.util.function.Predicate;
import model.Candidate;

/**
 * Your help with a election is needed. Given list of candidates, where each element
 * has Candidate.class type.
 * Check which candidates are eligible to apply for president position and return their
 * names sorted alphabetically.
 * The requirements are: person should be older than 35 years, should be allowed to vote,
 * have nationality - 'Ukrainian'
 * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
 * which has following view: "2002-2015"
 * We want to reuse our validation in future, so let's write our own impl of Predicate
 * parametrized with Candidate in CandidateValidator.
 */
public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQURIED_NATIONALITY = "Ukrainian";
    private static final int UKRAINE_LIVING_PERIOD_YEARS = 10;
    private static final int UPPER_PERIOD_INDEX = 1;
    private static final int LOWER_PERIOD_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (candidate.getNationality() != REQURIED_NATIONALITY) {
            return false;
        }
        String[] period = candidate.getPeriodsInUkr().split("-");
        if (Integer.valueOf(period[UPPER_PERIOD_INDEX])
                - Integer.valueOf(period[LOWER_PERIOD_INDEX])
                < UKRAINE_LIVING_PERIOD_YEARS) {
            return false;
        }
        return candidate.isAllowedToVote();
    }
}
