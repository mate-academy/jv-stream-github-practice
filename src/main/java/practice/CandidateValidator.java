package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;
    private static final String CITIZENSHIP_UK = "Ukrainian";
    private static final String REGEX = "-";
    private static final int MIN_PERIOD_LIVES_IN_UK = 10;
    private static final int MIN_YEARS_OLD = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] startAndEndPeriod = candidate.getPeriodsInUkr().split(REGEX);
        int periodInUk = Integer.parseInt(startAndEndPeriod[END_YEAR])
                - Integer.parseInt(startAndEndPeriod[START_YEAR]);
        return candidate.getAge() >= MIN_YEARS_OLD
                && candidate.getNationality().equals(CITIZENSHIP_UK)
                && candidate.isAllowedToVote()
                && periodInUk >= MIN_PERIOD_LIVES_IN_UK;
    }
}
