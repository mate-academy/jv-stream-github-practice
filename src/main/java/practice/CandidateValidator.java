package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int FROM_AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String LINE = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(LINE);
        int yearsInUkraine = Integer.parseInt(periodInUkraine[FIRST_INDEX])
                - Integer.parseInt(periodInUkraine[ZERO_INDEX]);
        return candidate.getAge() >= FROM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine >= YEARS_IN_UKRAINE;
    }
}
