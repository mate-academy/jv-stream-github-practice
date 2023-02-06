package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";
    private static final int INDEX_PERIOD_IN_UKRAINE_START = 0;
    private static final int INDEX_PERIOD_IN_UKRAINE_END = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        boolean inUkraineForTenYears =
                Integer.parseInt(periodInUkraine[INDEX_PERIOD_IN_UKRAINE_END])
                        - Integer.parseInt(periodInUkraine[INDEX_PERIOD_IN_UKRAINE_START])
                        > 10;

        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ELIGIBLE_NATIONALITY)
                && inUkraineForTenYears;
    }
}
