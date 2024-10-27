package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String YEARS_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && calculateYearsStayingInUkraine(candidate.getPeriodsInUkr()) >= YEARS_IN_UKRAINE;

    }

    private int calculateYearsStayingInUkraine(String years) {
        return Arrays.stream(years.split(YEARS_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .reduce((a, b) -> b - a)
                .orElse(0);

    }
}
