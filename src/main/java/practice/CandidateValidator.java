package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIODS = 10;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && calculatePeriods(candidate.getPeriodsInUkr());
    }

    private boolean calculatePeriods(String periods) {
        String[] year = periods.split("-");
        int startYear = Integer.parseInt(year[START_YEAR_INDEX]);
        int endYear = Integer.parseInt(year[END_YEAR_INDEX]);
        return endYear - startYear >= MIN_PERIODS;
    }
}
