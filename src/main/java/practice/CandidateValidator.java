package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_FROM = 0;
    private static final int PERIOD_TO = 1;
    private static final String SEPARATOR = "-";
    private static final String UA_NATIONALITY = "Ukrainian";
    private static final int MIN_LIVING_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UA_NATIONALITY)
                && periodsInUkr(candidate.getPeriodsInUkr()) >= MIN_LIVING_IN_UKRAINE;
    }

    private int periodsInUkr(String periodsInUkr) {
        String[] periods = periodsInUkr.split(SEPARATOR);
        return Integer.parseInt(periods[PERIOD_TO])
                - Integer.parseInt(periods[PERIOD_FROM]);
    }
}
