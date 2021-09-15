package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final int PERIOD_FROM = 0;
    private static final int PERIOD_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(periods[PERIOD_TO]) - Integer.parseInt(periods[PERIOD_FROM]);
        return candidate.isAllowedToVote() && candidate.getAge() >= MINIMAL_AGE
                    && candidate.getNationality().equals(NATIONALITY)
                    && period >= PERIOD_IN_UKRAINE;
    }
}
