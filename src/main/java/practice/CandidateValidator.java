package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATION_MARK = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitCandidate = candidate.getPeriodsInUkr().split(SEPARATION_MARK);
        int yearsInUkr = Arrays.stream(splitCandidate)
                .map(String::trim)
                .map(Integer::parseInt)
                .reduce((a, b) -> b - a)
                .orElse(0);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInUkr >= MIN_YEARS_IN_UKRAINE;
    }
}
