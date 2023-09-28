package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final String SEPARATOR = "-";
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SEPARATOR);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && Integer.parseInt(period[END_PERIOD_INDEX])
                - Integer.parseInt(period[START_PERIOD_INDEX]) >= MIN_PERIOD;
    }
}
