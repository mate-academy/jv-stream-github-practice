package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        List<Integer> periodInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkraine.get(0) - periodInUkraine.get(1) >= 10
                && candidate.isAllowedToVote();
    }
}
