package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PRESIDENT_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final String PERIOD_DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        boolean ageCheck = candidate.getAge() >= MIN_PRESIDENT_AGE;
        boolean voteCheck = candidate.isAllowedToVote();
        boolean nationalityCheck = REQUIRED_NATIONALITY.equals(candidate.getNationality());
        boolean periodCheck =
                calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= REQUIRED_YEARS_IN_UKRAINE;

        return ageCheck && voteCheck && nationalityCheck && periodCheck;
    }

    private int calculateYearsInUkraine(String period) {
        if (period == null || !period.contains("-")) {
            return 0;
        }

        String[] parts = period.split(PERIOD_DELIMITER);

        return Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) + 1;
    }
}
