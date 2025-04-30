package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;
    private static final int START_YEAR_PART_INDEX = 0;
    private static final int END_YEAR_PART_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String periods = candidate.getPeriodsInUkr();
        if (periods == null || !periods.matches("\\d{4}-\\d{4}")) {
            throw new IllegalArgumentException(
                    "Invalid period format, expected 'startYear-endYear'");
        }
        String[] period = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(period[START_YEAR_PART_INDEX]);
        int endYear = Integer.parseInt(period[END_YEAR_PART_INDEX]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && (endYear - startYear) >= MIN_PERIOD;
    }
}
