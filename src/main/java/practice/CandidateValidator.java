package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_ALLOWED = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_ALLOWED = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= AGE_ALLOWED
                && candidate.getNationality().equals(NATIONALITY)
                && periodToElect(candidate.getPeriodsInUkr());
    }

    private boolean periodToElect(String period) {
        List<Integer> periods = Arrays.stream(period.split("-"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return periods.get(1) - periods.get(0) >= PERIOD_ALLOWED;
    }

}
