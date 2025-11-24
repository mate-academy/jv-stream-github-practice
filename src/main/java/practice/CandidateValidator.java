package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final long REQUIRED_PERIODS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {

        boolean meetsBasicRequirements = candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY);

        if (!meetsBasicRequirements) {
            return false;
        }

        long totalYears = Arrays.stream(candidate.getPeriodsInUkr().split(","))
                .map(String::trim)
                .mapToLong(period -> {
                    String[] years = period.split("-");
                    if (years.length != 2) {
                        return 0;
                    }
                    try {
                        int startYear = Integer.parseInt(years[0].trim());
                        int endYear = Integer.parseInt(years[1].trim());
                        return endYear - startYear;
                    } catch (NumberFormatException e) {
                        return 0;
                    }
                })
                .sum();

        return totalYears >= REQUIRED_PERIODS_IN_UKR;
    }
}
