package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int NEED_AGE = 35;
    private static final int NEED_PERIOD = 10;
    private static final String NEED_NATIONALITY = "Ukrainian";
    private static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] candidatePeriod = candidate.getPeriodsInUkr().split(DELIMITER);
        int periodInUrk = Integer.parseInt(candidatePeriod[1])
                - Integer.parseInt(candidatePeriod[0]);
        return candidate.getAge() >= NEED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NEED_NATIONALITY)
                && periodInUrk > NEED_PERIOD;
    }
}
