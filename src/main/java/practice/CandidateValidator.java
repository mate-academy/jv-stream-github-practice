package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(",");
        int totalYears = 0;

        for (String period : periods) {
            String[] years = period.split("-");
            if (years.length == 2) {
                try {
                    int startYear = Integer.parseInt(years[0].trim());
                    int endYear = Integer.parseInt(years[1].trim());
                    totalYears += (endYear - startYear);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid period format: " + period);
                }
            } else {
                throw new IllegalArgumentException("Invalid period format: " + period);
            }
        }

        return totalYears >= YEARS_IN_UKRAINE;
    }
}
