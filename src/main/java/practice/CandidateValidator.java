package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int CANDIDATE_AGE = 35;
    public static final int NEEDED_YEARS_TO_LIVE = 10;
    public static final int CURRENT_YEAR = 2021;
    public static final int FIRST_YEAR_INDEX = 0;
    public static final int SECOND_YEAR_INDEX = 1;
    public static final int EMPTY_STRING_SIZE = 0;
    public static final String CANDIDATE_NATIONALITY = "Ukrainian";
    public static final String YEAR_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && hasLivedLongEnough(candidate);
    }

    private boolean hasLivedLongEnough(Candidate candidate) {
        String[] livingPeriod = candidate.getPeriodsInUkr().split(YEAR_REGEX);
        int firstYear = Integer.parseInt(livingPeriod[FIRST_YEAR_INDEX]);
        int secondYear = livingPeriod[SECOND_YEAR_INDEX].length() > EMPTY_STRING_SIZE
                ? Integer.parseInt(livingPeriod[SECOND_YEAR_INDEX]) : CURRENT_YEAR;
        return secondYear - firstYear >= NEEDED_YEARS_TO_LIVE;
    }
}


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
