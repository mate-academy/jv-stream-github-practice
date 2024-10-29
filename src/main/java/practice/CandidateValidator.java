package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkrArray = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(periodInUkrArray[1])
                - Integer.parseInt(periodInUkrArray[0])) >= 10;
    }

    @Override
    public Predicate and(Predicate other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate or(Predicate other) {
        return Predicate.super.or(other);
    }
}
