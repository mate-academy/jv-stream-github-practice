package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DASH = "-";
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && isPeriodEnough(candidate.getPeriodsInUkr());
    }

    private boolean isPeriodEnough(String period) {
        String[] split = period.split(DASH);
        int calculatedPeriod = Integer.parseInt(split[YEAR_TO])
                - Integer.parseInt(split[YEAR_FROM]);
        return calculatedPeriod >= MIN_PERIOD;
    }
}
