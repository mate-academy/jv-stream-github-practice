package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_START_INDEX = 0;
    private static final int PERIOD_END_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String LINE = "-";
    private static final String UA_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(LINE);
        int startYear = Integer.parseInt(periodInUkraine[PERIOD_START_INDEX]);
        int endYear = Integer.parseInt(periodInUkraine[PERIOD_END_INDEX]);
        int yearsInUkraine = endYear - startYear;
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UA_NATIONALITY)
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
