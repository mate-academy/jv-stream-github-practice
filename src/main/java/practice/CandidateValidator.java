package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final String CITIZENSHIP_UA = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int MIN_PERIOD_LIVES_IN_UA = 10;
    private static final int MIN_YEARS_OLD = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_YEARS_OLD
                && candidate.getNationality().equals(CITIZENSHIP_UA)
                && candidate.isAllowedToVote()
                && periodInUA(candidate) >= MIN_PERIOD_LIVES_IN_UA;
    }

    private int periodInUA(Candidate candidate) {
        String[] startAndEndPeriod = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(startAndEndPeriod[END_YEAR_INDEX])
                - Integer.parseInt(startAndEndPeriod[START_YEAR_INDEX]);
    }
}
