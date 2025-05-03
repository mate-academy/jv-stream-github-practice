package practice;

import java.util.function.Predicate;
import model.Candidate;
/**
 * Your help with a election is needed. Given list of candidates, where each element has
 * Candidate.class type. Check which candidates are eligible to apply for president position and
 * return their names sorted alphabetically. The requirements are: person should be older than 35
 * years, should be allowed to vote, have nationality - 'Ukrainian' and live in Ukraine for 10
 * years. For the last requirement use field periodsInUkr, which has following view: "2002-2015" We
 * want to reuse our validation in future, so let's write our own impl of Predicate parametrized
 * with Candidate in CandidateValidator.
 */

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate c) {
        if (c.getAge() < MIN_AGE
                || !c.isAllowedToVote()
                || !NATIONALITY.equals(c.getNationality())) {
            return false;
        }
        String[] splitedPeriod = c.getPeriodsInUkr().split(SEPARATOR);
        int startYear = Integer.parseInt(splitedPeriod[0]);
        int endYear = Integer.parseInt(splitedPeriod[1]);
        return (endYear - startYear) >= PERIOD_IN_UKRAINE;
    }
}


