package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public boolean test(Candidate candidate) {
        String[] periodInUAstring = candidate.getPeriodsInUkr().split("-");
        int periodInUA = Integer.parseInt(periodInUAstring[1])
                - Integer.parseInt(periodInUAstring[0]);
        return (candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUA >= 10);
    }
    //write your code here
}
