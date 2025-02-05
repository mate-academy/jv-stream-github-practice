package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate {
    //write your code here
    @Override
    public boolean test(Object o) {
        Candidate candidate = (Candidate) o;
        String[] ages = candidate.getPeriodsInUkr()
                .split("-");
        int agesInUkr = Integer.valueOf(ages[1]) - Integer.valueOf(ages[0]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && agesInUkr >= 10
                && candidate.getNationality().equals("Ukrainian");
    }
}
