package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_PERIOD_IN_UKR = 10;
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKR)
                && isPeriodValid(candidate);
    }

    private boolean isPeriodValid(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(years[END_PERIOD_INDEX])
                - Integer.parseInt(years[START_PERIOD_INDEX]) >= MINIMUM_PERIOD_IN_UKR;
    }
}
