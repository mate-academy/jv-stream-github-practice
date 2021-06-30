package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SPLITTER_OF_DATE = "-";
    private static final String REQUIREMENT_NATIONAL = "Ukrainian";
    private static final int REQUIREMENT_AGE = 35;
    private static final int REQUIREMENT_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        return candidate.getAge() >= REQUIREMENT_AGE
                && candidate.getNationality().equals(REQUIREMENT_NATIONAL)
                && candidate.isAllowedToVote()
                && validatePeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean validatePeriodInUkraine(String periodsInUkr) {
        String[] yearsInUkr = periodsInUkr.split(SPLITTER_OF_DATE);
        int period = Integer.parseInt(yearsInUkr[1]) - Integer.parseInt(yearsInUkr[0]);
        return period >= REQUIREMENT_PERIOD_IN_UKR;
    }
}
