package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_FROM_INDEX = 0;
    private static final int PERIOD_TO_INDEX = 1;
    private static final int MIN_REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(periods[PERIOD_TO_INDEX])
                - Integer.parseInt(periods[PERIOD_FROM_INDEX]);

        return candidate.getAge() >= MIN_REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodInUkr >= MIN_PERIOD_IN_COUNTRY;
    }
}
