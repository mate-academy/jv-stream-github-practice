package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() <= 35) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }

        String[] time = candidate.getPeriodsInUkr().split("-");
        int startPeriod = Integer.parseInt(time[0]);
        int finishPeriod = Integer.parseInt(time[1]);

        if (finishPeriod - startPeriod < 10) {
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
