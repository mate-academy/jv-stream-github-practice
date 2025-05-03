package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && countYearsByPeriod(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKR;
    }

    private int countYearsByPeriod(String period) {
        String[] years = period.split("-");
        return Integer.parseInt(years[YEAR_TO_INDEX]) - Integer.parseInt(years[YEAR_FROM_INDEX]);
    }
}
