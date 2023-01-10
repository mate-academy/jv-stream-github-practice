package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;

    private static final int PERIOD_FROM_INDEX = 1;
    private static final int PERIOD_TO_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] livingPeriodArray = candidate.getPeriodsInUkr().split("-");
        int livingYear = Integer.parseInt(livingPeriodArray[PERIOD_FROM_INDEX])
                - Integer.parseInt(livingPeriodArray[PERIOD_TO_INDEX]);
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote() && livingYear >= REQUIRED_YEARS_IN_UKRAINE;
    }
}
