package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ELIGIBLE_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        if (period == null || !period.matches("\\d{4}-\\d{4}")) {
            return false;
        }
        String[] years = period.split(PERIOD_DELIMITER);
        return candidate.getAge() >= MIN_ELIGIBLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= MIN_YEARS_IN_UKRAINE;
    }
}
