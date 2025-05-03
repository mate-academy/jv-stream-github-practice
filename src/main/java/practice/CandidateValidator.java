package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIODS = 10;
    private static final String PERMITTED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        List<Integer> periods = Arrays.stream(candidate.getPeriodsInUkr()
                        .split("-"))
                .map(Integer::parseInt)
                .toList();
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), PERMITTED_NATIONALITY)
                && (periods.get(1) - periods.get(0)) >= MIN_PERIODS;
    }
}
