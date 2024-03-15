package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String NATIONAL = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {

        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONAL)
                && liveInUkr(candidate) >= YEARS_IN_UKRAINE;
    }

    private int liveInUkr(Candidate candidate) {
        String[] inUkr = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(inUkr[1]) - Integer.parseInt(inUkr[0]);

    }
}
