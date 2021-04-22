package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && isRequestedPeriod(candidate);
    }

    private boolean isRequestedPeriod(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        int index0fDelimiter = period.indexOf(DELIMITER);
        int fromYear = Integer.parseInt(period.substring(0, index0fDelimiter));
        int toYear = Integer.parseInt(period.substring(index0fDelimiter + 1));
        return toYear - fromYear >= MIN_PERIOD_IN_UKRAINE;
    }
}
