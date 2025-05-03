package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS_TO_LIVE_IN_UKR = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int yearInUkr = Integer.parseInt(periods[YEAR_TO_INDEX])
                - Integer.parseInt(periods[YEAR_FROM_INDEX]);
        if (candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearInUkr >= REQUIRED_YEARS_TO_LIVE_IN_UKR) {
            return true;
        }
        return false;
    }
}
