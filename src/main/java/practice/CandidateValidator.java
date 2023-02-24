package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T> implements Predicate<T> {

    private static final int AGE_FROM = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int FROM_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(T t) {
        Candidate c = (Candidate) t;
        int firstDate = Integer.valueOf(c.getPeriodsInUkr().split("-")[0]);
        int secondDate = Integer.valueOf(c.getPeriodsInUkr().split("-")[1]);
        return c.getAge() >= AGE_FROM
                && c.isAllowedToVote()
                && c.getNationality().equals(VALID_NATIONALITY)
                && (secondDate - firstDate) >= FROM_PERIOD_IN_UKR;
    }
    //write your code here
}
