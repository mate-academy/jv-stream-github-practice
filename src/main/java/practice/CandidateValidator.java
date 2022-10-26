package practice;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_CANDIDATE = "Ukrainian";
    private static final int ALLOWED_CANDIDATE_AGE = 35;
    private static final int ALLOWED_PERIOD_OF_LIVING = 10;
    private static final String PERIOD_IN_UKRAINE_SPRITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedPeriodsInUkraine = candidate.getPeriodsInUkr()
                .split(PERIOD_IN_UKRAINE_SPRITER);
        int periodsInUkraine = Arrays.stream(splitedPeriodsInUkraine)
                .mapToInt(Integer::parseInt)
                .reduce((result, value) -> Math.abs(result - value))
                .orElseThrow();
        return candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), UKRAINIAN_CANDIDATE)
                && candidate.getAge() >= ALLOWED_CANDIDATE_AGE
                && periodsInUkraine > ALLOWED_PERIOD_OF_LIVING;
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
