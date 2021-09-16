package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate {
    @Override
    public boolean test(Object c) {
        Candidate candidate = (Candidate) c;
        String[] split = candidate.getPeriodsInUkr().split("-");
       int difference = Math.abs(Integer.parseInt(split[0]) - Integer.parseInt(split[1]));
        boolean validPerionInUkraine = difference > 10;
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && candidate.getAge() >= 35
                && validPerionInUkraine;
    }


}
