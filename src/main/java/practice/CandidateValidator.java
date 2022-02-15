package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && findPeriodInUkraine(candidate) >= 10;
    }
    private int findPeriodInUkraine (Candidate candidate){
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        return Integer.valueOf(yearsInUkraine[1]) - Integer.valueOf(yearsInUkraine[0]);
    }
    //write your code here
}
