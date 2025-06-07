package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int liveInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split(",")).toList()
                .stream()
                .map(s -> s.split("-"))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .reduce((left, right) -> right - left)
                .stream().sum();
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && liveInUkraine >= LIVE_IN_UKRAINE;
    }
}
