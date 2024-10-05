package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_PERIODS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE_FOR_CANDIDATE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (NATIONALITY != candidate.getNationality()) {
            return false;
        }

        String[] time = candidate.getPeriodsInUkr().split("-");
        int startPeriod = Integer.parseInt(time[0]);
        int finishPeriod = Integer.parseInt(time[1]);

        if (finishPeriod - startPeriod < MIN_PERIODS_IN_UKRAINE) {
            return false;
        }

        return true;
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
}
