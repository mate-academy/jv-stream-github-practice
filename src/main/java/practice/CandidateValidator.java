package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int SECOND_YEAR_INDEX = 1;
    private static final int MINIMAL_YEAR_IN_COUNTRY = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && isTruePeriodInUkraine(candidate);
    }

    private boolean isTruePeriodInUkraine(Candidate candidate) {
        String[] arrayOfYears = candidate.getPeriodsInUkr().split("-");
        int distinct = Integer.parseInt(arrayOfYears[SECOND_YEAR_INDEX])
                - Integer.parseInt(arrayOfYears[FIRST_YEAR_INDEX]);
        return distinct >= MINIMAL_YEAR_IN_COUNTRY;
    }
    //write your code here
}
