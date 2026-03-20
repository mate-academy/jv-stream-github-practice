package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        // age (35 is allowed)
        if (candidate.getAge() < 35) {
            return false;
        }

        // voting right
        if (!candidate.isAllowedToVote()) {
            return false;
        }

        // nationality
        String nationality = candidate.getNationality();
        if (nationality == null || !"Ukrainian".equalsIgnoreCase(nationality.trim())) {
            return false;
        }

        // periods
        String periods = candidate.getPeriodsInUkr();
        if (periods == null || periods.isBlank()) {
            return false;
        }

        String[] ranges = periods.split(",");

        int totalYears = 0;

        for (String range : ranges) {
            try {
                String[] years = range.trim().split("-");
                if (years.length != 2) {
                    continue;
                }

                int start = Integer.parseInt(years[0].trim());
                int end = Integer.parseInt(years[1].trim());

                totalYears += (end - start + 1);

            } catch (NumberFormatException e) {
                // ignore invalid ranges
            }
        }

        return totalYears >= 10;
    }
}
