package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final int REQUIREMENT_YEARS = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && wasLivingTenYearsInCountry(candidate.getPeriodsInUkr());
    }

    private boolean wasLivingTenYearsInCountry(String period) {
        String[] years = period.split(SEPARATOR);
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= REQUIREMENT_YEARS;
    }
}
