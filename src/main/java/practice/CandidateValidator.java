package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE_FROM = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MINIMAL_PERIOD_IN_UKRAINE = 10;
    private static final String PERIOD_SPLITTER = "-";
    private static final int PERIOD_YEAR_FROM_INDEX = 1;
    private static final int PERIOD_YEAR_TO_INDEX = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(PERIOD_SPLITTER);
        int periodInUkraine = Integer.parseInt(yearsInUkraine[PERIOD_YEAR_FROM_INDEX])
                - Integer.parseInt(yearsInUkraine[PERIOD_YEAR_TO_INDEX]);

        return candidate.getAge() >= ALLOWED_AGE_FROM
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && periodInUkraine >= MINIMAL_PERIOD_IN_UKRAINE;
    }
}
