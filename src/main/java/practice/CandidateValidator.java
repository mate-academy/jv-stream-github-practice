package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_CANDIDATE_LIVE_PERIOD_IN_COUNTRY = 10;
    private static final String REQUIRED_CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int PERIOD_START_DATE_INDEX = 0;
    private static final int PERIOD_END_DATE_INDEX = 1;
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
        String[] years = candidate.getPeriodsInUkr().split("-");
        int periodStart = Integer.parseInt(years[PERIOD_END_DATE_INDEX]);
        int periodEnd = Integer.parseInt(years[PERIOD_START_DATE_INDEX]);
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_CANDIDATE_NATIONALITY)
                && periodStart - periodEnd >= MIN_CANDIDATE_LIVE_PERIOD_IN_COUNTRY;
    }
}
