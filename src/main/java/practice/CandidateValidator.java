package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY_REQUIRED = "Ukrainian";
    private static final int MIN_AVAILABLE_PERIOD = 10;
    private static final String PERIOD_REGEX = "-";
    private static final int INDEX_OF_PERIOD_START = 0;
    private static final int INDEX_OF_PERIOD_END = 1;
    private static final int MIN_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(NATIONALITY_REQUIRED)) {
            return false;
        }
        return getPeriodInUkraineInt(candidate.getPeriodsInUkr()) >= MIN_AVAILABLE_PERIOD;
    }

    private int getPeriodInUkraineInt(String period) {
        if (period != null && !period.isEmpty()) {
            String[] years = period.split(PERIOD_REGEX);
            try {
                return Integer.parseInt(years[INDEX_OF_PERIOD_END])
                        - Integer.parseInt(years[INDEX_OF_PERIOD_START]) + MIN_PERIOD;
            } catch (NumberFormatException e) {
                throw new RuntimeException("Wrong format of period");
            }
        }
        return 0;
    }
    //write your code here
}
