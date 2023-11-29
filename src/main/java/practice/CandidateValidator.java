package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS = 10;
    private static final String SPACE_SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int[] years = Arrays.stream(candidate.getPeriodsInUkr().split(SPACE_SEPARATOR))
                .mapToInt(year -> Integer.parseInt(year))
                .toArray();
        int periodsInUkr = years[1] - years[0];
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodsInUkr >= MIN_YEARS;
    }
}
