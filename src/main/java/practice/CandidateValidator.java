package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SPLITTER_OF_DATE = "-";
    private static final String REQUIREMENTS_NATIONAL = "Ukrainian";
    private static final int REQUIREMENTS_AGE = 35;
    private static final int REQUIREMENTS_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        return candidate.getAge() >= REQUIREMENTS_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase(REQUIREMENTS_NATIONAL)
                && validatePeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean validatePeriodInUkraine(String periodsInUkr) {
        String[] yearsInUkr = periodsInUkr.split(SPLITTER_OF_DATE);
        int period = Integer.parseInt(yearsInUkr[1]) - Integer.parseInt(yearsInUkr[0]);
        return period >= REQUIREMENTS_PERIOD_IN_UKR;
    }
}
