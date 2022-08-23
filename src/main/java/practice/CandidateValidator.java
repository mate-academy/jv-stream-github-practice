package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int IN_UKRAINE_FROM = 0;
    private static final int IN_UKRAINE_TILL = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals("Ukrainian")) {
            return false;
        }
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodInUkraine[IN_UKRAINE_TILL])
                - Integer.parseInt(periodInUkraine[IN_UKRAINE_FROM]) >= 10;
    }
}
