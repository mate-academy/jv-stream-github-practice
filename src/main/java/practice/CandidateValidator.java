package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split("-");
        int inted = Integer.parseInt(splitted[1]) - Integer.parseInt(splitted[0]);
        if (candidate.isAllowedToVote() && candidate.getAge() >= 35 && candidate.getNationality().equals("Ukrainian")
        && inted >= 10) {
            return true;
        }
        return false;
    }

    //write your code here
}
