package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        List<String> periods = Arrays.stream(candidate.getPeriodsInUkr().split(","))
                .toList();

        int liveInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split(",")).toList()
                .stream()
                .map(s -> s.split("-"))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .reduce((i, j) -> j - i)
                .stream().boxed().max(Integer::compareTo).orElse(0);

        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && liveInUkraine >= LIVE_IN_UKRAINE;
    }
}
