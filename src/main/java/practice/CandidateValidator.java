package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T extends Candidate> implements Predicate<T> {
    public static final int MIN_AGE = 35;
    public static final int LIVE_PERIOD = 10;
    public static final String YEARS_SEPARATOR = "-";
    public static final String NATIONALITY = "Ukrainian";
    public static final int TO_YEAR = 1;
    public static final int FROM_YEAR = 0;

    @Override
    public boolean test(T t) {
        return t.getAge() >= MIN_AGE
                && t.isAllowedToVote()
                && t.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(t.getPeriodsInUkr().split(YEARS_SEPARATOR)[TO_YEAR])
                - Integer.parseInt(t.getPeriodsInUkr().split(YEARS_SEPARATOR)[FROM_YEAR]))
                >= LIVE_PERIOD;
    }
}
