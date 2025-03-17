package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String PERIOD_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }

        if (!REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }

        String[] periods = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        if (periods.length != 2) {
            return false;
        }

        try {
            int startYear = Integer.parseInt(periods[0]);
            int endYear = Integer.parseInt(periods[1]);
            return endYear - startYear >= MIN_YEARS_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
