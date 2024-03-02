package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE_FOR_CANDIDATE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int[] intPeriod = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY)
                && intPeriod[1] - intPeriod[0] >= MIN_YEARS_IN_UKRAINE;
    }
}
