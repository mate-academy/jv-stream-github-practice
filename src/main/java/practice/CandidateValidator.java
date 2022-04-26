package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_BOUND = 35;
    private static final String NATION = "Ukrainian";
    private static final int LIVED_IN_UKRAINE = 10;
    private static final boolean VOTE_RIGHT = true;
    private static final int LAST_YEAR = 1;
    private static final int FIRST_YEAR = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] inUkraine = candidate.getPeriodsInUkr().split("-");
        int yearInUkraine = Integer.parseInt(inUkraine[LAST_YEAR])
                - Integer.parseInt(inUkraine[FIRST_YEAR]);
        return candidate.getAge() >= AGE_BOUND
                && candidate.getNationality().equals(NATION)
                && candidate.isAllowedToVote()
                && yearInUkraine >= LIVED_IN_UKRAINE;
    }
}
