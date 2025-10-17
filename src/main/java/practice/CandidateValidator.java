package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr()
                .trim()
                .split(",");

        int totalYears = 0;

        for (String period : periods) {
            String[] years = period.trim().split("-");
            if (years.length != 2) {
                return false;
            }

            try {
                int start = Integer.parseInt(years[0].trim());
                int end = Integer.parseInt(years[1].trim());
                totalYears += (end - start);
            } catch (NumberFormatException e) {
                return false;
            }

        }
        boolean livedEnough = totalYears >= MIN_YEARS_IN_COUNTRY;

        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality()) && livedEnough;
    }
}
