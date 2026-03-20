package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS = 10;
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        // age
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }

        // voting right
        if (!candidate.isAllowedToVote()) {
            return false;
        }

        // nationality
        String nationality = candidate.getNationality();
        if (nationality == null || !NATIONALITY_UKRAINIAN.equalsIgnoreCase(nationality.trim())) {
            return false;
        }

        // periods
        String periods = candidate.getPeriodsInUkr();
        if (periods == null || periods.isBlank()) {
            return false;
        }

        String[] ranges = periods.split(",");

        int totalYears = Arrays.stream(ranges)
                .mapToInt(range -> {
                    try {
                        String[] years = range.trim().split("-");
                        if (years.length != 2) {
                            return 0;
                        }

                        int start = Integer.parseInt(years[0].trim());
                        int end = Integer.parseInt(years[1].trim());

                        return end - start + 1;
                    } catch (NumberFormatException e) {
                        return 0;
                    }
                })
                .sum();

        return totalYears >= MIN_YEARS;
    }
}
