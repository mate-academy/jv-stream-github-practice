package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVING_PERIOD = 10;
    private static final int YEAR_STATRT_ID = 0;
    private static final int YEAR_END_ID = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUk = candidate.getPeriodsInUkr().split("-");
        int currentLivingPeriod = Integer.parseInt(periodInUk[YEAR_END_ID])
                - Integer.parseInt(periodInUk[YEAR_STATRT_ID]);
        return candidate.getAge() >= MIN_AGE 
                && candidate.isAllowedToVote()
                && candidate.getNationality() == NATIONALITY
                && currentLivingPeriod >= LIVING_PERIOD;
    }
}
