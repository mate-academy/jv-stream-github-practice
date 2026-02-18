package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_RESIDENCY_YEARS_UKRAINE = 10;

    private int livedYearsInUkraine(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();

        if (period == null) {
            throw new IllegalArgumentException("Period is null.");
        }
        if (period.isBlank()) {
            throw new IllegalArgumentException("Period is empty.");
        }

        String[] parts = period.split("-");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Period must be in format 'YYYY-YYYY'");
        }

        try {
            int start = Integer.parseInt(parts[0].trim());
            int end = Integer.parseInt(parts[1].trim());

            if (end < start) {
                throw new IllegalArgumentException("End year cannot be smaller than start year.");
            }

            return end - start;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid year format in period: " + period, e);
        }
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                        && candidate.isAllowedToVote()
                        && candidate.getNationality().equalsIgnoreCase(REQUIRED_NATIONALITY)
                        && livedYearsInUkraine(candidate) >= MIN_RESIDENCY_YEARS_UKRAINE;
    }
}
