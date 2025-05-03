package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_LIVE_UKRAINE = 10;
    private static final String HYPHEN = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && wasLivingTenYearsInCountry(candidate.getPeriodsInUkr());
    }

    private boolean wasLivingTenYearsInCountry(String period) {
        String[] years = period.split(HYPHEN);
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= MIN_LIVE_UKRAINE;
    }
}
