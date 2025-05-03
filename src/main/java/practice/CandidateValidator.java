package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LOWER_BOUND = 35;
    private static final String NATION = "Ukrainian";
    private static final int LIVED_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] inUkraine = candidate.getPeriodsInUkr().split("-");
        int yearInUkraine = Integer.parseInt(inUkraine[1])
                - Integer.parseInt(inUkraine[0]);
        return candidate.getAge() >= AGE_LOWER_BOUND
                && candidate.getNationality().equals(NATION)
                && candidate.isAllowedToVote()
                && yearInUkraine >= LIVED_IN_UKRAINE;
    }
}
