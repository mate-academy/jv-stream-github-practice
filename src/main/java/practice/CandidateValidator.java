package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String PERIOD_SPLIT_REGEX = "-";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;
    private static final int AGE_CRITERIA = 35;
    private static final int PERIOD_IN_UKR_CRITERIA = 10;
    private static final String NATIONALITY_CRITERIA = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_CRITERIA
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_CRITERIA)
                && getPeriodInUkr(candidate.getPeriodsInUkr()) > PERIOD_IN_UKR_CRITERIA;
    }

    private int getPeriodInUkr(String period) {
        String[] splitPeriod = period.split(PERIOD_SPLIT_REGEX);
        return Integer.parseInt(splitPeriod[TO_YEAR]) - Integer.parseInt(splitPeriod[FROM_YEAR]);
    }
}
