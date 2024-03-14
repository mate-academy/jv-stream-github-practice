package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_BARRIER = 35;
    private static final int AGE_LIVED = 10;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        int fromYear = Integer.parseInt(candidate.getPeriodsInUkr().split(REGEX)[FROM_YEAR_INDEX]);
        int toYear = Integer.parseInt(candidate.getPeriodsInUkr().split(REGEX)[TO_YEAR_INDEX]);

        return candidate.getAge() >= AGE_BARRIER && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && Math.abs(fromYear - toYear) >= AGE_LIVED;
    }
}
