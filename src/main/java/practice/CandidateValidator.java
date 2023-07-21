package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_LIVED = 10;
    private static final int INDEX_YEAR_FROM = 0;
    private static final int INDEX_YEAR_TO = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && isLivedTenYear(candidate.getPeriodsInUkr());
    }

    private boolean isLivedTenYear(String input) {
        String[] years = input.split(SEPARATOR);
        int lived = Integer.parseInt(years[INDEX_YEAR_TO])
                - Integer.parseInt(years[INDEX_YEAR_FROM]);
        return lived >= MIN_YEARS_LIVED;
    }
}
