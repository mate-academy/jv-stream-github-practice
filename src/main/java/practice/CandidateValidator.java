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
                && livedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineForTenYears(String period) {
        try {
            String[] years = period.trim().split("-");
            int start = Integer.parseInt(years[0].trim());
            int end = Integer.parseInt(years[1].trim());
            return (end - start) >= MIN_YEARS_IN_UKRAINE;
        } catch (Exception e) {
            throw new RuntimeException("Invalid period format: " + period, e);
        }
    }
}
