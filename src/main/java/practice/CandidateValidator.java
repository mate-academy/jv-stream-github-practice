package practice;

import java.util.function.Function;
import java.util.function.Predicate;
import model.Candidate;

/**
 * The requirements are: person should be older than 35 years, should be allowed to vote,
 * have nationality - 'Ukrainian'
 * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
 * which has following view: "2002-2015"
 * We want to reuse our validation in future, so let's write our own impl of Predicate
 * parametrized with Candidate in CandidateValidator.
 */
public class CandidateValidator implements Predicate<Candidate> {
    private static Integer apply(String arg) {
        return Integer.parseInt(arg.split("-")[1]) - Integer.parseInt(arg.split("-")[0]);
    }

    @Override
    public boolean test(Candidate candidate) {
        Function<String, Integer> getPeriod = CandidateValidator::apply;
        
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && getPeriod.apply(candidate.getPeriodsInUkr()) >= 10;
    }
}
