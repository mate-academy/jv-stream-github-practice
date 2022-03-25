package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUARED_AGE = 35;
    private static final int REQUARED_YEARS = 10;
    private static final String REQUARED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return isValidCandidate(candidate);
    }

    private static boolean isValidCandidate(Candidate candidate) {
        return candidate.getNationality().equals(REQUARED_NATIONALITY)
                && candidate.isAllowedToVote()
                && candidate.getAge() >= REQUARED_AGE
                && getYearsFromPeriod(candidate.getPeriodsInUkr()) >= REQUARED_YEARS;
    }

    private static int getYearsFromPeriod(String periodsInUkr) {
        return Arrays.stream(periodsInUkr.split("-"))
                .map(Integer::valueOf)
                .mapToInt(i -> i)
                .reduce(0, (left, right) -> right - left);

    }
}
