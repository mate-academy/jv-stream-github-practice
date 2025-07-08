package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String hyphenSeparator = "-";

    @Override
    public boolean test(Candidate candidate) {
        String startLiveInUkraine = candidate.getPeriodsInUkr().split(hyphenSeparator)[0];
        String endLiveInUkraine = candidate.getPeriodsInUkr().split(hyphenSeparator)[1];
        int liveInUkraine = Integer.parseInt(endLiveInUkraine)
                - Integer.parseInt(startLiveInUkraine);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && liveInUkraine >= LIVE_IN_UKRAINE;
    }
}
