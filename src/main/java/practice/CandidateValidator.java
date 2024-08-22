package practice;

import ecxeption.CandidateValidationException;
import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int period = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::valueOf)
                .reduce((x1, x2) -> x2 - x1).orElseThrow(()
                        -> new CandidateValidationException("period data is incorrect"));
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase(UKRAINIAN_NATIONALITY)
                && period >= MIN_PERIOD_IN_UKRAINE;
    }
}
