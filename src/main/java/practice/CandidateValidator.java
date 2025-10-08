package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS = 10;

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
        if (!livedAtLeastYears(period, REQUIRED_YEARS)) {
            return false;
        }
        return true;
    }

    private boolean livedAtLeastYears(String period, int minYears) {
        if (period == null || period.isBlank()) {
            return false;
        }

        String[] ranges = period.split(",");

        int totalYears = 0;

        for (String range : ranges) {
            if (!range.contains("-")) {
                continue; // pomiń błędne wpisy
            }

            String[] years = range.trim().split("-");
            if (years.length != 2) {
                continue;
            }

            try {
                int start = Integer.parseInt(years[0].trim());
                int end = Integer.parseInt(years[1].trim());
                if (end > start) {
                    totalYears += (end - start);
                }
            } catch (NumberFormatException e) {
                // ignoruj błędne dane
                continue;
            }
        }

        return totalYears >= minYears;
    }
}
