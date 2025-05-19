package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && validatePeriodsInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean validatePeriodsInUkraine(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.isEmpty()) {
            return false;
        }
        String[] years = periodsInUkr.split("-");
        if (years.length != 2) {
            return false;
        }
        try {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            return (endYear - startYear + 1) >= MIN_YEARS_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
