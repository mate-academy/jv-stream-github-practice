package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate c) {
        if (c.getAge() <= MIN_AGE) {
            return false;
        }
        if (!c.isAllowedToVote()) {
            return false;
        }
        if (!"Ukrainian".equals(c.getNationality())) {
            return false;
        }

        String[] parts = c.getPeriodsInUkr().split("-");
        int from = Integer.parseInt(parts[0]);
        int to = Integer.parseInt(parts[1]);

        return to - from >= REQUIRED_YEARS_IN_UKRAINE;
    }
}