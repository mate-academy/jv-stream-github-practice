package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";

    public boolean isValid(Candidate candidate) {
        return ((candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && periodFromString(candidate.getPeriodsInUkr())
                >= MIN_PERIOD_IN_UKRAINE));
    }

    private int periodFromString(String period) {
        String[] years = period.split("-");
        int startYear = 0;
        int endYear = 0;
        try {
            startYear = Integer.parseInt(years[0]);
            endYear = Integer.parseInt(years[1]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return endYear - startYear;
    }

    @Override
    public boolean test(Candidate candidate) {
        return isValid(candidate);
    }
}
