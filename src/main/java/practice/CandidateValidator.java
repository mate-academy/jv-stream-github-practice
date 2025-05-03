package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS = 10;
    private static final String SPACE_SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_YEAR = 0;
    private static final int FINAL_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        int[] years = Arrays.stream(candidate.getPeriodsInUkr().split(SPACE_SEPARATOR))
                .mapToInt(year -> Integer.parseInt(year))
                .toArray();
        int periodsInUkr = years[FINAL_YEAR] - years[START_YEAR];
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodsInUkr >= MIN_YEARS;
    }
}
