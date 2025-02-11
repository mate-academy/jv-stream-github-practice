package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_DELIMITER = "-";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int MIN_REQUIRED_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.isAllowedToVote()
                || !candidate.getNationality().equals(REQUIRED_NATIONALITY)
                || candidate.getAge() < MIN_REQUIRED_AGE) {
            return false;
        }

        String[] split = candidate.getPeriodsInUkr().split(PERIOD_DELIMITER);
        if (split.length != 2) {
            throw new IllegalArgumentException("Invalid period format: "
                    + candidate.getPeriodsInUkr());
        }

        int startYear = Integer.parseInt(split[START_INDEX]);
        int endYear = Integer.parseInt(split[END_INDEX]);
        return (endYear - startYear) >= 10;
    }
}
