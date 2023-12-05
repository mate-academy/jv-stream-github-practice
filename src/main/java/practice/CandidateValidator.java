package practice;


import model.Candidate;

import java.util.List;
import java.util.function.Predicate;


public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && candidate.getPeriodsInUkr().matches("\\d{4}-\\d{4}");
    }
}
