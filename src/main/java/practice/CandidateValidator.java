package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int MIN_YEARS_OLD = 35;
    private static final String ALOW_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(periodInUkraine[1])
                - Integer.parseInt(periodInUkraine[0]);
        return candidate.getAge() >= MIN_YEARS_OLD
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALOW_NATIONALITY)
                && yearsInUkraine > MIN_YEARS_IN_UKRAINE;
    }
}
