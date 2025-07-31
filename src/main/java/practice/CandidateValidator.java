package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int YEARS_PAIR_LENGTH = 2;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        return livedEnoughInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean livedEnoughInUkraine(String period) {
        String[] years = period.split("-");
        if (years.length != YEARS_PAIR_LENGTH) {
            return false;
        }
        try {
            int fromYear = Integer.parseInt(years[0].trim());
            int toYear = Integer.parseInt(years[1].trim());
            return (toYear - fromYear) >= MIN_YEARS_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
