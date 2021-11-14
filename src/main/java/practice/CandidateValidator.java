package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && parseDiffYears(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_COUNTRY
                && candidate.isAllowedToVote()) {
            return true;
        }
        return false;
    }

    private int parseDiffYears(String value) {
        return Integer.parseInt(value.split("-")[1]) - Integer.parseInt(value.split("-")[0]);
    }
}
