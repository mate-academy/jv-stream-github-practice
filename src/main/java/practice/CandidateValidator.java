package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] arrFromToDates = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(arrFromToDates[1])
                - Integer.parseInt(arrFromToDates[0]);
        return candidate.getAge() >= 35
                && Objects.equals(candidate.getNationality(),"Ukrainian")
                && periodInUkr >= 10
                && candidate.isAllowedToVote();
    }
    /*The requirements are: person should be older than 35 years, should be allowed to vote,
            * have nationality - 'Ukrainian'
            * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
            * which has following view: "2002-2015"*/
}
