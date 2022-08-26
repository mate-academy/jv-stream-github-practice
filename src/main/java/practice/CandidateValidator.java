package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final int MIN_LIVE_YEARS_IN_UKRAINE = 10;
    private static final int INDEX_TO_PERIOD = 1;
    private static final int INDEX_FROM_PERIOD = 0;
    private static final String DELIMITER = "-";
    private static final String REQUESTED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] splittedPeriods = candidate.getPeriodsInUkr().split(DELIMITER);

        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUESTED_NATIONALITY)
                && candidate.getAge() >= MIN_ALLOWED_AGE
                && Integer.parseInt(splittedPeriods[INDEX_TO_PERIOD])
                - Integer.parseInt(splittedPeriods[INDEX_FROM_PERIOD]) >= MIN_LIVE_YEARS_IN_UKRAINE;

    }
}
