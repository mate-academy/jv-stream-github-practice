package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_REQUIRED_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD_IN_UKRAINE = 10;
    private static final int YEAR_IN_UKRAINE_FROM = 0;
    private static final int YEAR_IN_UKRAINE_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(periodInUkraine[YEAR_IN_UKRAINE_TO])
                - Integer.parseInt(periodInUkraine[YEAR_IN_UKRAINE_FROM]);
        return candidate.getAge() >= MIN_REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine >= REQUIRED_PERIOD_IN_UKRAINE;
    }
}
