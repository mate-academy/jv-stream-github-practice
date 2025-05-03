package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final String SEPARATOR = "-";
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && isEnoughTime(candidate);
    }

    private boolean isEnoughTime(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(SEPARATOR);
        int period = Integer.parseInt(periodsInUkr[LAST_INDEX])
                - Integer.parseInt(periodsInUkr[FIRST_INDEX]);
        return period >= MIN_PERIOD;
    }
}
