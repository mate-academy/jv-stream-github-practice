package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_FACTOR = 35;
    private static final int YEARS_IN_UKRAINE_FACTOR = 10;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;
    private static final String UKRAINE_NATIONALITY_FACTOR = "Ukrainian";
    private static final String COMMA = ",";
    private static final String PERIOD_DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_FACTOR
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINE_NATIONALITY_FACTOR)
                && Arrays.stream(candidate.getPeriodsInUkr().split(COMMA))
                        .mapToInt(period -> {
                            String[] periods = period.split(PERIOD_DELIMITER);
                            int startYear = Integer.parseInt(periods[START_YEAR]);
                            int endYear = Integer.parseInt(periods[END_YEAR]);
                            return endYear - startYear;
                        })
                        .sum() >= YEARS_IN_UKRAINE_FACTOR;
    }
}
