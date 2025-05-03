package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final int TO_YEAR_INDEX = 1;
    private static final int FROM_YEAR_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isValidPeriodInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean isValidPeriodInUkraine(String livingPeriod) {
        String[] boundaryDates = livingPeriod.split("-");
        int dateFrom = Integer.parseInt(boundaryDates[FROM_YEAR_INDEX]);
        int dateTo = Integer.parseInt(boundaryDates[TO_YEAR_INDEX]);
        return dateTo - dateFrom >= MIN_PERIOD;
    }
}
