package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
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

        String period = candidate.getPeriodsInUkr();
        String[] years = period.split("-");

        if (years.length != 2) {
            return false;
        }
        try {
            int fromYear = Integer.parseInt(years[0]);
            int toYear = Integer.parseInt(years[1]);
            return (toYear - fromYear) >= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
