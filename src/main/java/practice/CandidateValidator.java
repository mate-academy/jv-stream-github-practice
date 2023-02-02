package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_CANDIDATE_AGE = 35;
    private static final String REQUIRED_CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_CANDIDATE_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_OF_DASH_IN_PERIOD_IN_UKRAINE = 5;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_CANDIDATE_NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(INDEX_OF_DASH_IN_PERIOD_IN_UKRAINE)))
                - (Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, INDEX_OF_DASH_IN_PERIOD_IN_UKRAINE - 1)))
                > REQUIRED_CANDIDATE_PERIOD_IN_UKRAINE;
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
