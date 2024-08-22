package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";

    public boolean isCandidateEligible(Candidate candidate) {
        return ((candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.isAllowedToVote()
                && ALLOWED_NATIONALITY.equals(candidate.getNationality())
                && periodFromString(candidate.getPeriodsInUkr())
                >= MIN_PERIOD_IN_UKRAINE));
    }

    private int periodFromString(String period) {
        if (period == null || !period.matches("\\d{4}-\\d{4}")) {
            throw new IllegalArgumentException("Invalid period format. "
                    + "Expected format: 'YYYY-YYYY'. Given: " + period);
        }

        String[] years = period.split("-");
        int startYear;
        int endYear;

        try {
            startYear = Integer.parseInt(years[0]);
            endYear = Integer.parseInt(years[1]);

            if (startYear > endYear) {
                throw new IllegalArgumentException(
                        "Start year cannot be greater than end year. "
                                + "Given period: " + period);
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Failed to parse years from the period: "
                    + period, e);
        }
        return endYear - startYear;
    }
    /*
    The method 'periodFromString' assumes the format of the period string is always correct.
    Consider adding validation for the input string format to avoid unexpected behavior.
     */

    @Override
    public boolean test(Candidate candidate) {
        return isCandidateEligible(candidate);
    }
}
