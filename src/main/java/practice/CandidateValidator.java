package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T> implements Predicate<T> {
    @Override
    public boolean test(T t) {
        Candidate candidate = (Candidate) t;
        int yearsInUkraine = Integer.parseInt(candidate.getPeriodsInUkr().substring(5, 9))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4));
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality()) && yearsInUkraine >= 10;
    }
}
