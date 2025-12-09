package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {

        if (candidate.getAge() < MIN_AGE) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }

        if (!REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        String[] years = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(years[0]);
        int toYear = Integer.parseInt(years[1]);

        return (toYear - fromYear) >= MIN_YEARS_IN_UKRAINE;
    }
}
