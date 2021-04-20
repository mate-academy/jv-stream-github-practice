package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;
    private static final String SPLITERATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return calculatePeriod(candidate.getPeriodsInUkr()) >= PERIOD_IN_UKRAINE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote();
    }

    private int calculatePeriod(String period) {
        return Integer.parseInt(period.split(SPLITERATOR)[END_PERIOD_INDEX])
                - Integer.parseInt(period.split(SPLITERATOR)[START_PERIOD_INDEX]);
    }
}
