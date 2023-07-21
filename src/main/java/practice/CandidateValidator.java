package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";
    private static final int INDEX_PERIOD_IN_UKRAINE_START = 0;
    private static final int INDEX_PERIOD_IN_UKRAINE_END = 1;
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        boolean inUkraineForTenYears =
                Integer.parseInt(periodInUkraine[INDEX_PERIOD_IN_UKRAINE_END])
                        - Integer.parseInt(periodInUkraine[INDEX_PERIOD_IN_UKRAINE_START])
                        > MIN_YEARS_IN_UKRAINE;

        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ELIGIBLE_NATIONALITY)
                && inUkraineForTenYears;
    }
}
