package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final String PERIOD_REGEX = "-";
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && haslivedInCountryForSpecifiedPeriod(candidate.getPeriodsInUkr())
                && candidate.getNationality().equals(REQUIRED_NATIONALITY);
    }

    private boolean haslivedInCountryForSpecifiedPeriod(String period) {
        String[] startAndEndOfPeriod = period.split(PERIOD_REGEX);
        int residencePeriod = Integer.parseInt(startAndEndOfPeriod[TO_YEAR_INDEX])
                - Integer.parseInt(startAndEndOfPeriod[FROM_YEAR_INDEX]);
        return residencePeriod >= MIN_PERIOD_IN_UKRAINE;
    }
}
