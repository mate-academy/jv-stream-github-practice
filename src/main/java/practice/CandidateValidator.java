package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int TEN_YEARS_IN_UKRAINE = 10;
    private static final int AGE_FROM = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String DELIMETER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() > AGE_FROM
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && Arrays.stream(candidate.getPeriodsInUkr().split(DELIMETER))
                .map(Integer::parseInt)
                .reduce((a, b) -> b - a)
                .get() >= TEN_YEARS_IN_UKRAINE;
    }
}
