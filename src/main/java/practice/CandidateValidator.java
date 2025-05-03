package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SUITABLE_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splittedYearsInUkraine
                = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(splittedYearsInUkraine[1])
                - Integer.parseInt(splittedYearsInUkraine[0]);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(SUITABLE_NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
