package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE || !candidate.isAllowedToVote()
                || !REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        String[] years = candidate.getPeriodsInUkr().trim().split("-");
        if (years.length != 2) {
            return false;
        }

        try {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);

            return endYear - startYear >= MIN_YEARS_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
