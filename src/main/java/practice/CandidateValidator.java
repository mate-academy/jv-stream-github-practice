package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOW_AGE = 35;
    private static final String ALLOW_NATIONALITY = "Ukrainian";
    private static final int PERIODS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        int reduce = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce(0, (left, right) -> right - left);

        return candidate.getAge() >= ALLOW_AGE
                && candidate.getNationality().equals(ALLOW_NATIONALITY)
                && candidate.isAllowedToVote()
                && reduce >= PERIODS_IN_UKR;
    }
}
