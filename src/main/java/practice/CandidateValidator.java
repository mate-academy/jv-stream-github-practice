package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int LIVE_YEARS_IN_UKRAINE = 10;
    private static final int MIN_YEARS_CANDIDATE = 35;
    private static final int START_LIVING_IN_UK_INDEX = 0;
    private static final int FINISH_LIVING_IN_UK_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        List<Integer> collect = Arrays
                .stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        int yearsInUkraine = collect.get(FINISH_LIVING_IN_UK_INDEX)
                - collect.get(START_LIVING_IN_UK_INDEX);
        if (candidate.getAge() >= MIN_YEARS_CANDIDATE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsInUkraine >= LIVE_YEARS_IN_UKRAINE) {
            return true;
        }
        return false;
    }
}
