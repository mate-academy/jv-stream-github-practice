package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UA = 10;
    private static final int FROM_PERIOD_INDEX = 0;
    private static final int TO_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        boolean isPeriodEnough =
                (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[TO_PERIOD_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[FROM_PERIOD_INDEX]))
                >= MIN_YEARS_IN_UA;
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && isPeriodEnough;
    }
}
