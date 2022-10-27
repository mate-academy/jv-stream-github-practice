package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SPLIT_FOR_DATE = "-";
    private static final int MIN_VALID_AGE = 35;
    private static final int MIN_VALID_PERIOD = 10;
    private static final int DATE_SIZE = 2;
    private static final String YEAR_FROM;
    private static final String YEAR_TO;
    private static String[] date;

    static {
        date = new String[DATE_SIZE];
        YEAR_FROM = date[0];
        YEAR_TO = date[1];
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isValidPeriods(candidate);
    }

    private boolean isValidPeriods(Candidate candidate) {
        date = candidate.getPeriodsInUkr().split(SPLIT_FOR_DATE);
        int yearFrom = Integer.parseInt(YEAR_FROM);
        int yearTo = Integer.parseInt(YEAR_TO);
        return yearTo - yearFrom >= MIN_VALID_PERIOD;
    }
}
