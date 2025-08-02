package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUEST_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final String PERIOD_REGEX = "\\d{4}-\\d{4}";
    private static final String PERIOD_DELIMITER = "-";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUEST_NATIONALITY.equals(candidate.getNationality())
                && hasLivedInUkraineFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineFor10Years(String period) {
        if (period == null || !period.matches(PERIOD_REGEX)) {
            return false;
        }
        String[] parts = period.split(PERIOD_DELIMITER);
        try {
            int fromYear = Integer.parseInt(parts[FROM_YEAR_INDEX]);
            int toYear = Integer.parseInt(parts[TO_YEAR_INDEX]);
            return (toYear - fromYear) >= MIN_YEARS_IN_UKR;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
