package practice;

import model.Candidate;

import java.util.Arrays;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        //The requirements are: person should be older than 35 years, should be allowed to vote,
        //     * have nationality - 'Ukrainian'
        //     * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
        //     * which has following view: "2002-2015"
        if (candidate == null) {
            return false;
        }
        if (candidate.getAge() < 35) return false;
        if(!candidate.isAllowedToVote()) return false;
        if (!candidate.getNationality().equals("Ukrainian")) return false;
        String yearsInUkraine = candidate.getPeriodsInUkr();
        return Integer.parseInt(yearsInUkraine.substring(yearsInUkraine.indexOf("-")+1)) -
                Integer.parseInt(yearsInUkraine.substring(0, yearsInUkraine.indexOf("-"))) > 10;
    }
}
