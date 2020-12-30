package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && periodsInUkrMoreThen10(candidate);
    }

    private boolean periodsInUkrMoreThen10(Candidate candidate) {
        List<Integer> yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return yearsInUkraine.get(1) - yearsInUkraine.get(0) >= MIN_YEARS;
    }
}
