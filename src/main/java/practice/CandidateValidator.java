package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_PERIOD_LIVING_IN_UKRAINE = 10;
    private static final int MIN_REQUIRED_CANDIDATE_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedPeriod = candidate.getPeriodsInUkr().split("-");
        int countedPeriodResult = Integer.parseInt(splitedPeriod[1])
                - Integer.parseInt(splitedPeriod[0]);
        return candidate.getAge() >= MIN_REQUIRED_CANDIDATE_AGE
               && candidate.isAllowedToVote()
               && candidate.getNationality().equals(REQUIRED_NATIONALITY)
               && countedPeriodResult >= REQUIRED_PERIOD_LIVING_IN_UKRAINE;

    }
}
