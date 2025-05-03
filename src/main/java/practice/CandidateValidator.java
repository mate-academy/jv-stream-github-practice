package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    public static final int MIN_PERIOD_IN_UKRAINE = 10;
    public static final int VALID_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        Integer[] period = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        int yearsInUkraine = period[1] - period[0];

        return candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && yearsInUkraine >= MIN_PERIOD_IN_UKRAINE;
    }
}
