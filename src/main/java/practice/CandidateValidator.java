package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_TIME_LIVING_IN_UA = 10;
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
        String[] livingYears = candidate.getPeriodsInUkr().trim().split("-");
        int startLiving = Integer.parseInt(livingYears[0]);
        int endLiving = Integer.parseInt(livingYears[1]);
        int timeLiving = endLiving - startLiving;

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && timeLiving >= MIN_TIME_LIVING_IN_UA;
    }
}
