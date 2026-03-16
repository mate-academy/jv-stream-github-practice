package practice;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

/**
 * Custom predicate to validate Candidate according to requirements:
 * - at least MIN_AGE years old
 * - allowedToVote == true
 * - nationality equals REQUIRED_NATIONALITY
 * - total years lived in Ukraine (sum of periods) >= REQUIRED_YEARS_IN_UKR
 *
 * Periods string format example: "2002-2015" or multiple periods separated by comma:
 * "1990-1994,1996-2010"
 */
public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        if (candidate.getAge() < MIN_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!Objects.equals(candidate.getNationality(), REQUIRED_NATIONALITY)) {
            return false;
        }
        String periods = candidate.getPeriodsInUkr();
        if (periods == null || periods.isBlank()) {
            return false;
        }
        // periods may be comma-separated; each period is "start-end"
        try {
            int totalYears = parseTotalYears(periods);
            return totalYears >= REQUIRED_YEARS_IN_UKR;
        } catch (Exception e) {
            // if parsing fails treat candidate as invalid
            return false;
        }
    }

    private int parseTotalYears(String periods) {
        return Arrays.stream(periods.split("\\s*,\\s*"))
                .mapToInt(part -> {
                    String[] bounds = part.split("\\s*-\\s*");
                    if (bounds.length != 2) {
                        throw new IllegalArgumentException("Invalid period format: " + part);
                    }
                    int start = Integer.parseInt(bounds[0]);
                    int end = Integer.parseInt(bounds[1]);
                    // assume end >= start; count years as (end - start)
                    return Math.max(0, end - start);
                })
                .sum();
    }
}
