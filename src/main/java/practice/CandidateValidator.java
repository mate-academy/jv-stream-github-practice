package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_OF_LIVING_IN_UKRAINE = 10;
    private static final String PERIOD_SEPARATOR = "-";
    private static final int START_PERIOD = 0;
    private static final int END_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && getPeriodInUkraine(candidate) >= REQUIRED_PERIOD_OF_LIVING_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    private int getPeriodInUkraine(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);
        return Integer.parseInt(periodInUkraine[END_PERIOD])
                - Integer.parseInt(periodInUkraine[START_PERIOD]);
    }
}
