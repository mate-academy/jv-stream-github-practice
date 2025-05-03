package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int PERIOD_LIVING_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DATE_SEPARATOR = "-";
    private static final int START_PERIOD = 0;
    private static final int END_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && isValidPeriodInUkraine(candidate);
    }

    private boolean isValidPeriodInUkraine(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        String[] periods = period.split(DATE_SEPARATOR);
        int startPeriod = Integer.parseInt(periods[START_PERIOD]);
        int endPeriod = Integer.parseInt(periods[END_PERIOD]);
        return (endPeriod - startPeriod) >= PERIOD_LIVING_IN_UKRAINE;
    }
}
