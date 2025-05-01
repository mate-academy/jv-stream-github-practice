package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String YEAR_RANGE_SEPARATOR = "-";
    private static final String ACCEPTABLE_NATIONALITY = "Ukrainian";
    private static final int YEAR_FROM_COLUMN = 0;
    private static final int YEAR_TO_COLUMN = 1;
    private static final int MIN_ACCEPTABLE_AGE = 35;
    private static final int MIN_ACCEPTABLE_NUMBERS_OF_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] dividedDate = candidate.getPeriodsInUkr().split(YEAR_RANGE_SEPARATOR);
        int dateFrom = Integer.parseInt(dividedDate[YEAR_FROM_COLUMN]);
        int dateTo = Integer.parseInt(dividedDate[YEAR_TO_COLUMN]);

        return (dateTo - dateFrom >= MIN_ACCEPTABLE_NUMBERS_OF_YEARS)
                && (candidate.getAge() >= MIN_ACCEPTABLE_AGE)
                && (candidate.getNationality().equals(ACCEPTABLE_NATIONALITY))
                && (candidate.isAllowedToVote());
    }
}
