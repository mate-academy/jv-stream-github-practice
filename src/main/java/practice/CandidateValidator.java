package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVING_AGE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int[] ints = Arrays.stream(candidate.getPeriodsInUkr()
                        .split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int livingAge = ints[1] - ints[0];
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && livingAge >= MIN_LIVING_AGE;
    }
}
