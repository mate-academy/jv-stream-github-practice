package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_TIME_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::valueOf)
                .mapToInt(Integer::valueOf)
                .reduce((left, right) -> right - left)
                .getAsInt() >= MIN_TIME_IN_UKR;
    }
}
