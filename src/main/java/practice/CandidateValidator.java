package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_TO_LIVE_IN_UA = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && isValidPeriod(candidate.getPeriodsInUkr());
    }

    private boolean isValidPeriod(String period) {
        String[] split = period.split("-");
        int indexFrom = 0;
        int indexTo = 1;
        int yearFrom = Integer.parseInt(split[indexFrom]);
        int yearTo = Integer.parseInt(split[indexTo]);
        return yearTo - yearFrom >= MIN_YEARS_TO_LIVE_IN_UA;
    }
}
