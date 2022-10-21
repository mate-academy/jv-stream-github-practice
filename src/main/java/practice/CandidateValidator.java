package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_VALIDATE_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int YEAR_TO_INDEX = 1;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int MIN_PERIOD_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_VALIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && calcPeriodInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_COUNTRY;
    }

    @Override
    public Predicate<Candidate> and(Predicate<? super Candidate> other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate<Candidate> negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate<Candidate> or(Predicate<? super Candidate> other) {
        return Predicate.super.or(other);
    }

    private int calcPeriodInUkr(String periodsInUkr) {
        return Integer.parseInt(periodsInUkr.split("-")[YEAR_TO_INDEX])
                - Integer.parseInt(periodsInUkr.split("-")[YEAR_FROM_INDEX]);
    }
}
