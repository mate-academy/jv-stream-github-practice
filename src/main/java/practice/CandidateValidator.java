package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_PRESIDENT_AGE = 35;
    private static final int MINIMUM_YEARS_FROM_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int PERIOD_START_DATE_INDEX = 0;
    private static final int PERIOD_END_DATE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_PRESIDENT_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getYearsFromPeriod(candidate.getPeriodsInUkr()) > MINIMUM_YEARS_FROM_PERIOD;
    }

    private int getYearsFromPeriod(String period) {
        String[] stringsArray = period.split("-");
        int fromYear = Integer.parseInt(stringsArray[PERIOD_START_DATE_INDEX]);
        int toYear = Integer.parseInt(stringsArray[PERIOD_END_DATE_INDEX]);
        return toYear - fromYear;
    }
}
