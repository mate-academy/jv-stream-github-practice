package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int LIMIT_BY_AGE = 35;
    private static final int LIMIT_BY_PERIOD_OF_LIVE = 10;
    private static final String SPLIT_INDEX = "-";
    private static final int INDEX_LIVE_FROM = 0;
    private static final int INDEX_LIVE_TO = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] fromToYears = candidate.getPeriodsInUkr().split(SPLIT_INDEX);
        int period = Integer.parseInt(fromToYears[INDEX_LIVE_TO])
                - Integer.parseInt(fromToYears[INDEX_LIVE_FROM]);
        return candidate.getAge() >= LIMIT_BY_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period >= LIMIT_BY_PERIOD_OF_LIVE;
    }
}
