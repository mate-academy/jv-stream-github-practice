package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;


public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIODS = 10;

    @Override
    public boolean test(Candidate candidate) {
        List<Integer> periods = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (periods.get(1) - periods.get(0)) >= MIN_PERIODS;
    }
}
