package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] PeriodsInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && Integer.parseInt(PeriodsInUkr[1]) - Integer.parseInt(PeriodsInUkr[0]) > 10;
    }
    //write your code here
}
