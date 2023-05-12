package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T extends Candidate> implements Predicate<T> {
    public static final int MIN_AGE = 35;
    public static final int LIVE_PERIOD = 10;
    public static final String YEARS_SEPARATOR = "-";

    @Override
    public boolean test(T t) {
        return t.getAge() >= MIN_AGE
                && t.isAllowedToVote()
                && t.getNationality().equals("Ukrainian")
                && (Integer.parseInt(t.getPeriodsInUkr().split(YEARS_SEPARATOR)[1])
                - Integer.parseInt(t.getPeriodsInUkr().split(YEARS_SEPARATOR)[0])) >= LIVE_PERIOD;
    }

    public static boolean staticPredicate(Candidate t) {
        return t.getAge() >= MIN_AGE
                && t.isAllowedToVote()
                && t.getNationality().equals("Ukrainian")
                && (Integer.parseInt(t.getPeriodsInUkr().split(YEARS_SEPARATOR)[1])
                - Integer.parseInt(t.getPeriodsInUkr().split(YEARS_SEPARATOR)[0])) >= LIVE_PERIOD;
    }
}
