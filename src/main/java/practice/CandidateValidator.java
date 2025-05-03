package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[LAST_YEAR_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[FIRST_YEAR_INDEX])
                > MIN_PERIOD_IN_UKR;
    }
}
