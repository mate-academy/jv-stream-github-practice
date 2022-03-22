package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int OPTIMAL_AGE = 35;
    private static final int VALID_YEARS_IN_UKR = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return isValidCandidate(candidate);
    }

    private static boolean isValidCandidate(Candidate candidate) {
        return candidate.getNationality().equals(VALID_NATIONALITY)
                && candidate.isAllowedToVote()
                && candidate.getAge() >= OPTIMAL_AGE
                && getYearsFromPeriod(candidate.getPeriodsInUkr()) >= VALID_YEARS_IN_UKR;
    }

    private static int getYearsFromPeriod(String periodsInUkr) {
        return Arrays.stream(periodsInUkr.split("-"))
                .map(Integer::valueOf)
                .mapToInt(i -> i)
                .reduce(0, (left, right) -> right - left);

    }
}
