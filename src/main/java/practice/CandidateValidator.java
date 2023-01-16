package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        List<Integer> collect = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Integer max = Collections.max(collect);
        Integer min = Collections.min(collect);
        AtomicInteger differnt = new AtomicInteger(max - min);
        if (candidate.getAge() >= 35 && candidate.getNationality().equals("Ukrainian")
                && differnt.get() >= 10) {
            return candidate.isAllowedToVote();
        }
        return false;
    }
}
