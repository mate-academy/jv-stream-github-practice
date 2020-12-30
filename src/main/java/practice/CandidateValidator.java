package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE_TO_BE_PRESIDENT = 35;
    private static final int MIN_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] temporaryArrayOfYears = candidate.getPeriodsInUkr().split("-");
        int[] yearsInUkraine = {Integer.parseInt(temporaryArrayOfYears[0]),
                Integer.parseInt(temporaryArrayOfYears[1])};
        return candidate.getAge() >= MIN_AGE_TO_BE_PRESIDENT && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine[1] - yearsInUkraine[0] >= MIN_YEARS_IN_UKR;
    }
}
