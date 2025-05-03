package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_THRESHOLD = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";
    private static final int FROM_THE_YEAR = 0;
    private static final int TO_THE_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_THRESHOLD
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && getPeriodInUkr(candidate) >= MIN_PERIOD_IN_UKR
                && candidate.isAllowedToVote();
    }

    private int getPeriodInUkr(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SPLITTER);
        return Integer.parseInt(period[TO_THE_YEAR]) - Integer.parseInt(period[FROM_THE_YEAR]);
    }
}
