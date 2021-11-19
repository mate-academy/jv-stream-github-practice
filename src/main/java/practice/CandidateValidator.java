package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        final int yearsInUkr = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .mapToInt(Integer::parseInt)
                .reduce((n1, n2) -> n2 - n1)
                .orElseThrow(() -> new NumberFormatException("Can't parse"));

        return (candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && yearsInUkr >= MIN_YEARS_IN_UKR);
    }
}
