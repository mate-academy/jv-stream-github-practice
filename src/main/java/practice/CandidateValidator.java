package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEAR = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int liveInUkraine = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        return (candidate.getAge() >= MIN_YEAR && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && liveInUkraine >= MIN_LIVE_IN_UKRAINE);
    }
}
