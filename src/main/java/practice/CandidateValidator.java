package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_PERIOD_LIVING_IN_UKRAINE = 10;
    private static final int MIN_REQUIRED_CANDIDATE_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int START_PERIOD_YEAR = 0;
    private static final int END_PREIOD_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitedPeriod = candidate.getPeriodsInUkr().split("-");
        int countedPeriodResult = Integer.parseInt(splitedPeriod[END_PREIOD_YEAR])
                - Integer.parseInt(splitedPeriod[START_PERIOD_YEAR]);
        return candidate.getAge() >= MIN_REQUIRED_CANDIDATE_AGE
               && candidate.isAllowedToVote()
               && candidate.getNationality().equals(REQUIRED_NATIONALITY)
               && countedPeriodResult >= REQUIRED_PERIOD_LIVING_IN_UKRAINE;

    }
}
