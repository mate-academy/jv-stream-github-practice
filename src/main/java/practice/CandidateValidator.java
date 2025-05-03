package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_RESIDENCY_PERIOD = 10;
    private static String NATIONALITY = "Ukrainian";
    private static final int PERIOD_START_DATE_INDEX = 0;
    private static final int PERIOD_END_DATE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getResidencyPeriod(candidate) >= REQUIRED_RESIDENCY_PERIOD;
    }
    
    private int getResidencyPeriod(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int realResidencyPeriod = Integer.parseInt(years[PERIOD_END_DATE_INDEX])
                - Integer.parseInt(years[PERIOD_START_DATE_INDEX]);
        return realResidencyPeriod;
    }
}
