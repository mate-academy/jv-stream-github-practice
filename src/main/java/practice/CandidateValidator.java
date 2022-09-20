package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int EXIT_FROM_UKRAINE = 1;
    private static final int COME_TO_UKRAINE = 0;
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(period[EXIT_FROM_UKRAINE])
                - Integer.parseInt(period[COME_TO_UKRAINE]) > MIN_PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
