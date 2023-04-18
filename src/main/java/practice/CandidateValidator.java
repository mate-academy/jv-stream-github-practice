package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public Predicate<Candidate> negate() {
        return null;
    }

    @Override
    public Predicate<Candidate> or(Predicate<? super Candidate> other) {
        return null;
    }

    @Override
    public boolean test(Candidate candidate) {
        return false;
    }

    @Override
    public Predicate<Candidate> and(Predicate<? super Candidate> other) {
        return null;
    }
}
