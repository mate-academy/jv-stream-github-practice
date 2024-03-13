package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_FOR_PRESIDENT = 35;
    private static final String NATIONALITY_FOR_PRESIDENT = "Ukrainian";
    private static final int PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getClass() == Candidate.class
                && candidate.getAge() >= AGE_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_FOR_PRESIDENT)
                && isLived(candidate);
    }

    private boolean isLived(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(split[1]) - Integer.parseInt(split[0]) >= PERIOD_IN_UKRAINE;
    }
}
