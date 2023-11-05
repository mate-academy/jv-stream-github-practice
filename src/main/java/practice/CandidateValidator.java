package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int candidatePeriodInUkraine =
                Integer.parseInt(years[TO_YEAR_INDEX]) - Integer.parseInt(years[FROM_YEAR_INDEX]);
        return candidate.isAllowedToVote()
                && (candidate.getAge() >= MIN_ALLOWED_AGE)
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && (candidatePeriodInUkraine >= MIN_PERIOD_IN_UKRAINE);
    }
}
