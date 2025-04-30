package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PERIOD_IN_UKRAINE_SEPARATOR = "-";
    private static final int MIN_AGE_ELIGIBILITY = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String ELIGIBILITY_NATIONALITY = "Ukrainian";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(PERIOD_IN_UKRAINE_SEPARATOR);
        int yearsInUkraine = Integer.parseInt(periodInUkraine[END_YEAR_INDEX])
                - Integer.parseInt(periodInUkraine[START_YEAR_INDEX]);
        return candidate.getAge() >= MIN_AGE_ELIGIBILITY && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ELIGIBILITY_NATIONALITY)
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
