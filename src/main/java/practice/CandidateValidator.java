package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE_FOR_PRESIDENT = 35;
    public static final int PERIOD_IN_UKRAINE_FROM = 0;
    public static final int PERIOD_IN_UKRAINE_TO = 1;
    public static final int MIN_LIMIT_OF_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.valueOf(candidate.getPeriodsInUkr().split("-")[PERIOD_IN_UKRAINE_TO])
                - Integer.valueOf(candidate.getPeriodsInUkr().split("-")[PERIOD_IN_UKRAINE_FROM])
                >= MIN_LIMIT_OF_YEARS;
    }
}
