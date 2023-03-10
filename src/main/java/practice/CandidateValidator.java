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
    private static final String SEPARATOR = "-";
    private static final int MIN_AGE = 35;
    private static final String REQURIED_NATIONALITY = "Ukrainian";
    private static final int UKRAINE_LIVING_PERIOD_YEARS = 10;
    private static final int UPPER_PERIOD_INDEX = 1;
    private static final int LOWER_PERIOD_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedPeriod = candidate.getPeriodsInUkr().split(SEPARATOR);
        int period = Integer.valueOf(splitedPeriod[UPPER_PERIOD_INDEX])
                - Integer.valueOf(splitedPeriod[LOWER_PERIOD_INDEX]);
        return period >= UKRAINE_LIVING_PERIOD_YEARS
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality() == REQURIED_NATIONALITY
                && candidate.isAllowedToVote();
    }
}
