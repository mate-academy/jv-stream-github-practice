package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        int one = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int two = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);
        return two - one >= 10
                && candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian");
    }
}
