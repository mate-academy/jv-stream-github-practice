package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int MIN_AGE_ALLOWED = 35;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final String REGEX = "-";
    private static final String ALLOWED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(REGEX);
        int fromYearInUkraine = Integer.parseInt(periodInUkr[FROM_YEAR_INDEX]);
        int toYearInUkraine = Integer.parseInt(periodInUkr[TO_YEAR_INDEX]);
        int candidatePeriodInUkraine = toYearInUkraine - fromYearInUkraine;
        return candidate.getAge() >= MIN_AGE_ALLOWED
                && candidate.isAllowedToVote()
                && candidatePeriodInUkraine >= MIN_PERIOD_IN_UKRAINE
                && candidate.getNationality().equals(ALLOWED_NATIONALITY);
    }
}
