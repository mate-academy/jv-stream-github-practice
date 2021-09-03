package practice;

import model.Candidate;

import java.util.Objects;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate>{
    private final static int ACCEPTABLE_AGE = 35;
    private final static int ACCEPTABLE_YEARS = 10;
    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ACCEPTABLE_AGE
                && "Ukrainian".equals(candidate.getNationality())
                && candidate.isAllowedToVote()
                && Integer.parseInt( candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]) >= ACCEPTABLE_YEARS;
    }
}
