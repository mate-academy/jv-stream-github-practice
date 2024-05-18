package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        Predicate<Candidate> olderThan35 = (i) -> i.getAge() >= 35;
        Predicate<Candidate> allowedVote = Candidate::isAllowedToVote;
        Predicate<Candidate> nationality = (i) -> i.getNationality().equals("Ukrainian");
        Predicate<Candidate> livedInUkr = (i) -> {
            String[] years = i.getPeriodsInUkr().split("-");
            return Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= 10;
        };
        return olderThan35.and(allowedVote).and(nationality).and(livedInUkr).test(candidate);
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
