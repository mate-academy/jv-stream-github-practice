package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int NECESSARY_AGE = 35;
    private static final int YEARS_OF_LIFE = 10;
    private static final String NECESSARY_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= NECESSARY_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NECESSARY_NATIONALITY)
                && periodsInUkraine(candidate) >= YEARS_OF_LIFE;
    }

    private int periodsInUkraine(Candidate candidate) {
        return Arrays.stream(candidate.getPeriodsInUkr().split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .reduce((a, b) -> b - a).orElse(0);
    }
}
