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
    private static final String ADMISSIBLE_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int START_LIVING_INDEX = 0;
    private static final int FINISH_LIVING_INDEX = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ADMISSIBLE_NATIONALITY)
                && checkPeriodInUkraine(candidate);
    }

    private boolean checkPeriodInUkraine(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(SEPARATOR);
        int period = Integer.parseInt(yearsInUkraine[FINISH_LIVING_INDEX])
                - Integer.parseInt(yearsInUkraine[START_LIVING_INDEX]);
        return period >= MIN_PERIOD_IN_UKRAINE;
    }
    //write your code here
}
