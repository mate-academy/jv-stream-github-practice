package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_LIVE_IN_UKRAINE = 10;
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] liveInUkraine = candidate.getPeriodsInUkr().split(REGEX);
        int years = Integer.parseInt(liveInUkraine[1])
                - Integer.parseInt(liveInUkraine[0]);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && years >= MINIMUM_LIVE_IN_UKRAINE;
    }
}
