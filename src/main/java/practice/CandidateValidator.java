package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int VALID_AMOUNT_OF_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int fromYearInUkraine = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int toYearInUkraine = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);
        int amountOfYearInUkraine = toYearInUkraine - fromYearInUkraine;

        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && amountOfYearInUkraine >= VALID_AMOUNT_OF_YEARS_IN_UKRAINE;
    }

}
