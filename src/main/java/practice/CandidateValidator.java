package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UA = 10;
    private static final String REQUIRED_NAT = "Ukrainian";

    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && isUkrainian(candidate.getNationality())
                && yearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UA;
    }

    private boolean isUkrainian(String nat) {
        return nat != null && REQUIRED_NAT.equalsIgnoreCase(nat.trim());
    }

    private int yearsInUkraine(String period) {
        if (period == null) {
            return 0;
        }
        String[] parts = period.split("-");
        if (parts.length != 2) {
            return 0;
        }
        try {
            int start = Integer.parseInt(parts[0].trim());
            int end = Integer.parseInt(parts[1].trim());
            return Math.max(0, end - start);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}


