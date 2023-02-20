package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T> implements Predicate<T> {
    @Override
    public boolean test(T t) {
        Candidate c = (Candidate) t;
        int firstDate = Integer.valueOf(c.getPeriodsInUkr().split("-")[0]);
        int secondDate = Integer.valueOf(c.getPeriodsInUkr().split("-")[1]);
        return c.getAge() >= 35
                && c.isAllowedToVote()
                && c.getNationality().equals("Ukrainian")
                && (secondDate - firstDate) >= 10;
    }
    //write your code here
}
