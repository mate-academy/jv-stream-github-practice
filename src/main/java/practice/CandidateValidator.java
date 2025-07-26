package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final String YEARS_SEPARATOR = "-";
    private static final int MIN_DURATION_OF_RESIDENCE_IN_UKRAINE = 10;
    private static final int INDEX_OF_FIRST_RESIDENCE_YEAR = 0;
    private static final int INDEX_OF_LAST_RESIDENCE_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), UKRAINIAN_NATIONALITY)
                && checkPeriodsInUkr(candidate);
    }

    private boolean checkPeriodsInUkr(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);
        int firstYear = Integer.parseInt(years[INDEX_OF_FIRST_RESIDENCE_YEAR]);
        int lastYear = Integer.parseInt(years[INDEX_OF_LAST_RESIDENCE_YEAR]);
        return lastYear - firstYear >= MIN_DURATION_OF_RESIDENCE_IN_UKRAINE;
    }
}
