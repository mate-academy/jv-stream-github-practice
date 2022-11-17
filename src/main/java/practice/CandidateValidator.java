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

    private static int MIN_AGE = 35;
    private static String REQUIRED_NATIONALITY = "Ukrainian";
    private static String REGEX = "-";
    private static int MIN_DURATION_IN_UK = 10;
    private static int FROM_YEAR_OF_LIVE_IN_UK = 0;
    private static int TO_YEAR_OF_LIVE_IN_UK = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUk = candidate.getPeriodsInUkr().split(REGEX);
        int durationLivingInUK = Integer.parseInt(periodsInUk[TO_YEAR_OF_LIVE_IN_UK])
                - Integer.parseInt(periodsInUk[FROM_YEAR_OF_LIVE_IN_UK]);
        boolean durationTrue = durationLivingInUK >= MIN_DURATION_IN_UK;
        return durationTrue
                && candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY);
    }
}
