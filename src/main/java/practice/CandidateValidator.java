package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final int VALID_PERIOD = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        List<Integer> periodInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        return candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && periodInUkraine.get(0) - periodInUkraine.get(1) >= VALID_PERIOD
                && candidate.isAllowedToVote();
    }
}
