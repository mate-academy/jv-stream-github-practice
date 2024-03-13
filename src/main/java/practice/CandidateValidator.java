package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SPLIT_REGEX = "-";
    private static final int MIN_VALID_AGE = 35;
    private static final int MIN_VALID_PERIOD = 10;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_VALID_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && calculatePeriodInUkraine(candidate) >= MIN_VALID_PERIOD;
    }

    private int calculatePeriodInUkraine(Candidate candidate) {
        String[] stringDates = candidate.getPeriodsInUkr().split(PERIOD_SPLIT_REGEX);
        int yearFrom = Integer.parseInt(stringDates[FROM_YEAR_INDEX]);
        int yearTo = Integer.parseInt(stringDates[TO_YEAR_INDEX]);
        return yearTo - yearFrom;
    }
}
