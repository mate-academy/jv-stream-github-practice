package practice;

import java.util.function.Predicate;
import model.Candidate;
/*The requirements are: person should be older than 35 years, should be allowed to vote,
 * have nationality - 'Ukrainian'
 * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
 * which has following view: "2002-2015"
 * We want to reuse our validation in future, so let's write our own impl of Predicate
 * parametrized with Candidate in CandidateValidator.
 */

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int periodInt = Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && periodInt >= MIN_PERIOD && candidate.isAllowedToVote();
    }
}
