package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ACCEPTABLE_AGE = 35;
    private static final int ACCEPTABLE_YEARS = 10;
    //write your code here

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ACCEPTABLE_AGE
                && "Ukrainian".equals(candidate.getNationality())
                && candidate.isAllowedToVote()
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]) >= ACCEPTABLE_YEARS;
    }
}
