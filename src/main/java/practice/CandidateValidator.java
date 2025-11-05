package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_REQUIRED_AGE = 35;
    private static final int MIN_YEARS_IN_UA = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        return isOlderThan(candidate, MIN_REQUIRED_AGE)
                && isAllowedToVote(candidate)
                && hasRequiredNationality(candidate, REQUIRED_NATIONALITY)
                && livedInUkraineForAtLeast(candidate, MIN_YEARS_IN_UA);
    }

    private boolean isOlderThan(Candidate candidate, int age) {
        return candidate.getAge() >= age;
    }

    private boolean isAllowedToVote(Candidate candidate) {
        return candidate.isAllowedToVote();
    }

    private boolean hasRequiredNationality(Candidate candidate, String nationality) {
        String candidateNationality = candidate.getNationality();

        return candidateNationality != null && candidateNationality
                .trim()
                .equalsIgnoreCase(nationality);
    }

    private boolean livedInUkraineForAtLeast(Candidate candidate, int minYears) {
        String period = candidate.getPeriodsInUkr();
        if (period == null) {
            return false;
        }

        String[] parts = period.trim().split("-");

        if (parts.length != 2) {
            return false;
        }

        try {
            int from = Integer.parseInt(parts[0].trim());
            int to = Integer.parseInt(parts[1].trim());

            return (to - from) >= minYears;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
