package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVING_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUk = candidate.getPeriodsInUkr().split("-");
        int currentLivingPeriod = Integer.parseInt(periodInUk[1])
                - Integer.parseInt(periodInUk[0]);
        return candidate.getAge() >= MIN_AGE 
                && candidate.isAllowedToVote()
                && candidate.getNationality() == NATIONALITY
                && currentLivingPeriod >= LIVING_PERIOD;
    }
}
