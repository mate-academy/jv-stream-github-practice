package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_OF_THE_CANDIDATE = 35;
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int FIRST_INDEX = 1;
    private static final int ZERO_INDEX = 0;
    private static final String YEARS_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int yearsInUkraine = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(YEARS_SEPARATOR)[FIRST_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split(YEARS_SEPARATOR)[ZERO_INDEX]);
        return candidate.getAge() >= MIN_AGE_OF_THE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine >= PERIOD_IN_UKRAINE;
    }
}
