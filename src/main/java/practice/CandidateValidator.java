package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_AGE = 35;
    private static final int INDEX_PERIOD_FROM = 0;
    private static final int INDEX_PERIOD_TO = 1;
    private static final int YEAR_LIMIT = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ELIGIBLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriodInUkraine(candidate) >= YEAR_LIMIT;
    }

    private int getPeriodInUkraine(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(REGEX);
        return Integer.parseInt(period[INDEX_PERIOD_TO])
                - Integer.parseInt(period[INDEX_PERIOD_FROM]);
    }
}
