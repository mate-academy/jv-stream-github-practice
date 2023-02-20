package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int THRESHOLD_AGE = 35;
    private static final int THRESHOLD_PERIOD = 10;
    private static final String SPLITTER = "-";
    private static final int START_YEAR_POSITION = 0;
    private static final int END_YEAR_POSITION = 1;

    @Override
    public boolean test(Candidate candidate) {
        String [] periodsInUkr = candidate.getPeriodsInUkr().split(SPLITTER);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= THRESHOLD_AGE
                && (Integer.parseInt(periodsInUkr[END_YEAR_POSITION])
                     - Integer.parseInt(periodsInUkr[START_YEAR_POSITION]) + 1) >= THRESHOLD_PERIOD;
    }
}
