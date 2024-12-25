package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MINIMAL_AGE = 35;
    private static final int MINIMAL_YEARS_IN_UA = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        List<Integer> years = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (years.get(1) - years.get(0)) >= MINIMAL_YEARS_IN_UA;
    }
}
