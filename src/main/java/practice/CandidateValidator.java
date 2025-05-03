package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SPLITERATOR = "-";
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final int PERIOD_START_INDEX = 0;
    private static final int PERIOD_END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(SPLITERATOR);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && (Integer.parseInt(periodInUkr[PERIOD_END_INDEX])
                - Integer.parseInt(periodInUkr[PERIOD_START_INDEX]) >= MIN_PERIOD);
    }
}
