package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 35;
    private static final int NEEDED_PERIOD = 10;
    private static final int PERIOD_START = 0;
    private static final int PERIOD_END = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkrArray = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.getAge() >= ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(periodsInUkrArray[PERIOD_END])
                - Integer.parseInt(periodsInUkrArray[PERIOD_START]) >= NEEDED_PERIOD;
    }
}
