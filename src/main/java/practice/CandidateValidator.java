package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }

        if (!NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        String[] years = candidate.getPeriodsInUkr().split("-");
        int firstYear = Integer.parseInt(years[0]);
        int lastYear = Integer.parseInt(years[1]);

        return (lastYear - firstYear) >= REQUIRED_YEARS_IN_UKRAINE;
    }
}
