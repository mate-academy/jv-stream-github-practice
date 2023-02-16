package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int THRESHOLD_AGE = 35;
    private static final int THRESHOLD_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String [] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= THRESHOLD_AGE
                && (Integer.parseInt(periodsInUkr[1])
                     - Integer.parseInt(periodsInUkr[0]) + 1) >= THRESHOLD_PERIOD;
    }
}
