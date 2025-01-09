package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int startYear = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        int endYear = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1]);
        int yearsInUkraine = endYear - startYear;

        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
