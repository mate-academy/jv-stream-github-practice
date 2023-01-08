package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AMOUNT_MIN_YEARS = 10;
    private static final int MIN_AGE = 35;
    private static final int YEARS_FROM_INDEX = 0;
    private static final int YEARS_TO_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        List<Integer> yearsFromTo = Arrays
                .stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        int yearsInUkraine = yearsFromTo.get(YEARS_TO_INDEX)
                - yearsFromTo.get(YEARS_FROM_INDEX);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkraine >= AMOUNT_MIN_YEARS;
    }
}
