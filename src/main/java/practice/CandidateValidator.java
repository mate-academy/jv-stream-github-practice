package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private Predicate<Candidate> toVote = Candidate::isAllowedToVote;
    private Predicate<Candidate> age = a -> a.getAge() >= 35;
    private Predicate<Candidate> isNationality = c -> c.getNationality().equals("Ukrainian");
    private Predicate<Candidate> period = p -> {
        String[] periodOfYear = p.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodOfYear[1]) - Integer.parseInt(periodOfYear[0]) >= 10;
    };

    @Override
    public Predicate<Candidate> and(Predicate<? super Candidate> other) {
        return null;
    }

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
        return toVote.test(candidate) && age.test(candidate)
                && isNationality.test(candidate) && period.test(candidate);
    }
}
