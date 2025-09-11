package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> { // minor comment

    private static final int MIN_ELIGIBLE_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        boolean ageValid = candidate.getAge() >= MIN_ELIGIBLE_AGE;
        boolean allowed = candidate.isAllowedToVote();
        boolean ukrainian = REQUIRED_NATIONALITY.equalsIgnoreCase(candidate.getNationality());

        String periods = candidate.getPeriodsInUkr();
        if (periods == null || periods.isBlank()) {
            return false;
        }

        String[] years = periods.split("\\s*-\\s*"); // split with optional spaces
        if (years.length != 2) {
            return false;
        }

        try {
            int from = Integer.parseInt(years[0]);
            int to = Integer.parseInt(years[1]);
            boolean lived10Years = (to - from) >= MIN_YEARS_IN_UKRAINE;
            return ageValid && allowed && ukrainian && lived10Years;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
