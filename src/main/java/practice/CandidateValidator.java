package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_STAY_IN_THE_COUNTRY = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE
                || !candidate.getNationality().equals(NATIONALITY)
                || !candidate.isAllowedToVote()) {
            return false;
        }
        return checkYearsInTheCountry(candidate.getPeriodsInUkr());
    }

    private boolean checkYearsInTheCountry(String period) {
        String[] parts = period.split(SEPARATOR);
        int start = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]);

        if (end < start) {
            throw new IllegalArgumentException("End date must not be before start date");
        }

        return end - start >= MIN_STAY_IN_THE_COUNTRY;
    }
}
