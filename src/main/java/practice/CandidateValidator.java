package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_REQUIRED_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_IN_UKRAINE = 10;

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

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(periodInUkraine[1])
                - Integer.parseInt(periodInUkraine[0]);
        return candidate.getAge() >= MIN_REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine >= REQUIRED_PERIOD_IN_UKRAINE;
    }
}
