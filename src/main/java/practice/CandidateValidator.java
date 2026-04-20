package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_ALLOWED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        if (candidate.getAge() < MIN_ALLOWED_AGE) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        String periods = candidate.getPeriodsInUkr();

        if (periods == null || periods.trim().isEmpty()) {
            return false;
        }

        int totalYears = 0;

        String[] parts = periods.split(",");

        for (String part : parts) {
            String p = part.trim();
            if (p.isEmpty()) {
                continue;
            }

            String[] range = p.split("-");
            if (range.length != 2) {
                return false;
            }

            try {
                int from = Integer.parseInt(range[0].trim());
                int to = Integer.parseInt(range[1].trim());

                if (to < from) {
                    return false;
                }

                totalYears += (to - from + 1);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return totalYears >= REQUIRED_YEARS_IN_UKR;
    }
}
