package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int AGE = 35;
    private static final int PERIOD = 10;
    private static final String SPLITERATOR = "-";
    private static final int START_PERIOD = 0;
    private static final int END_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(SPLITERATOR);
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(dates[END_PERIOD]) - Integer.parseInt(dates[START_PERIOD])
                    >= PERIOD;
    }
}
