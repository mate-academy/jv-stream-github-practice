package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && findPeriodInUkraine(candidate) >= MIN_YEARS_IN_UKRAINE;
    }

    private int findPeriodInUkraine(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(yearsInUkraine[1]) - Integer.parseInt(yearsInUkraine[0]);
    }
}
