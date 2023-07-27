package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final int MIN_YEARS_LIVING_IN_UKR = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && validatePeriodsInUkr(candidate.getPeriodsInUkr());
    }

    private boolean validatePeriodsInUkr(String periodsInUkr) {
        return Arrays.stream(periodsInUkr.split(PERIOD_SPLIT_REGEX))
                .mapToInt(Integer::parseInt)
                .reduce((x, y) -> y - x)
                .getAsInt() >= MIN_YEARS_LIVING_IN_UKR;
    }
}
