package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_AGE = 35;
    public static final int MIN_LIVING_PERIOND = 10;

    @Override
    public boolean test(Candidate candidate) {
        List<Integer> period = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && (period.get(1) - period.get(0) >= MIN_LIVING_PERIOND);
    }
}

