package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SPLITTER = "-";
    private static final int PERIOD_IN_UKR_FROM_INDEX = 0;
    private static final int PERIOD_IN_UKR_TO_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final String UKR_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKR_NATIONALITY)
                && getPeriodInUkr(candidate) >= MINIMUM_PERIOD_IN_UKR;
    }

    private int getPeriodInUkr(Candidate candidate) {
        String[] periodInUkArray = candidate.getPeriodsInUkr().split(SPLITTER);
        return Integer.parseInt(periodInUkArray[PERIOD_IN_UKR_TO_INDEX])
                - Integer.parseInt(periodInUkArray[PERIOD_IN_UKR_FROM_INDEX]);
    }
}
