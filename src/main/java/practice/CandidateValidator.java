package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_INUKR_SEPARATOR = 4;
    private static final int PERIOD_INUKR_LENGTH = 9;
    private static final int MIN_PERIOD_INUKR = 10;
    private static final int MIN_ALLOWED_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_ALLOWED_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(PERIOD_INUKR_SEPARATOR + 1, PERIOD_INUKR_LENGTH))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, PERIOD_INUKR_SEPARATOR)) >= MIN_PERIOD_INUKR;
    }
}
