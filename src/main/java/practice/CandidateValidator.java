package practice;

//Your help with an election is needed. Given list of candidates,
// where each element has Candidate.class type.
// Check which candidates are eligible to apply for president position
// and return their names sorted alphabetically.
// The requirements are: person should be at least 35 years old, should be allowed to vote,
// have nationality
// - 'Ukrainian' and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
// which has the following view: "2002-2015" For now we don't care if that was last 10 or not.
// We want to reuse our validation in the future,
// so let's write our own impl of Predicate in CandidateValidator.

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate {
    //write your code here
    private static final int VALID_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int VALID_LIFETIME = 10;

    protected Predicate<Candidate> candidateValidPredicate =
            candidate -> VALID_NATIONALITY.equals(candidate.getNationality())
                    && candidate.isAllowedToVote()
                    && candidate.getAge() >= VALID_AGE
                    && liveTimeInUkraine(candidate.getPeriodsInUkr()) >= VALID_LIFETIME;

    private int liveTimeInUkraine(String periodsInUkr) {
        String[] splittedPeriod = periodsInUkr.split("-");
        return Integer.parseInt(splittedPeriod[1]) - Integer.parseInt(splittedPeriod[0]);
    }

    @Override
    public boolean test(Object o) {
        return false;
    }
}
