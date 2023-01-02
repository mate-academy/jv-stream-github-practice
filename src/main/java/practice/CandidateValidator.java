package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && livesInUkraine(candidate)
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY);
    }

    private boolean livesInUkraine(Candidate candidate) {
        String[] p = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(p[1]) - Integer.parseInt(p[0]) >= LIVE_IN_UKRAINE;
    }
}
