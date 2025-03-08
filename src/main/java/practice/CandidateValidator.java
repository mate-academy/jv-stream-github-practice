package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase("UKRAINIAN")
                && candidate.getAge() >= 35
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0])) >= 10) {
            return true;
        }
        return false;
    }
}
