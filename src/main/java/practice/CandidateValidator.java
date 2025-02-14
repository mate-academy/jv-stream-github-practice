package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int NEED_AGE = 35;
    private static final int NEED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] candidatePeriod = candidate.getPeriodsInUkr().split("-");
        int periodInUrk = Integer.parseInt(candidatePeriod[1])
                - Integer.parseInt(candidatePeriod[0]);
        return candidate.getAge() >= NEED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUrk > NEED_PERIOD;
    }
}
