package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";
    private static final int PERIOD_ARRAY_LENGTH = 2;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), NATIONALITY)
                && liveTen(candidate.getPeriodsInUkr());
    }

    private boolean liveTen(String period) {
        String[] periods = period.split(REGEX);
        if (periods.length != PERIOD_ARRAY_LENGTH) {
            return false;
        }
        int startYear;
        int endYear;
        try {
            startYear = Integer.parseInt(periods[START_YEAR_INDEX]);
            endYear = Integer.parseInt(periods[END_YEAR_INDEX]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format. " + e.getMessage());
        }
        return endYear - startYear >= MIN_PERIOD_IN_UKR;
    }
}
