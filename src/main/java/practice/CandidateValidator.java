package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate c) {
        String[] periodArray = c.getPeriodsInUkr().split("-");
        int difference = Integer.parseInt(periodArray[1]) - Integer.parseInt(periodArray[0]);
        return c.getAge() >= 35 && c.isAllowedToVote() && c.getNationality().equals("Ukrainian")
                && difference >= 10;
    }
    //write your code here

}
